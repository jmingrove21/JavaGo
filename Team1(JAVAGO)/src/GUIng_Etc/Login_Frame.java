package GUIng_Etc;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/* Login_Frame class
 * Usage : make login panel shown when clicked editer button
 * */
public class Login_Frame extends JDialog implements ActionListener {

	private JPanel panel; // declare panel that contain contents
	private JLabel login_title; // declare title label 
	private JButton pk_image1; // declare JButton that is pokemon head image
	private JButton pk_image2; // declare JButton that is pokemon head image
	private JButton pk_image3; // declare JButton that is pokemon head image
	private JButton pk_image4; // declare JButton that is pokemon head image
	private JButton pk_image5; // declare JButton that is pokemon head image
	private JButton login_exit; // declare JButton that has exit function
	private JButton login; //  declare JButton that run the program if the id is collect

	private ButtonGroup bt1 = new ButtonGroup(); // make ButtonGroup that contain pokemon head image button
	private JTextField name; // declare JTextField that typte the ID
	Base_Element bs_elem = new Base_Element(); // make Base_Element objct
	public Login_Frame() {
		this.setUndecorated(true);
		this.setSize(400, 300);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
				(int) (di.getHeight() / 2 - di1.getHeight() / 2));

		var_init();
		panel_init();
		login_title_init();
		login_exit_init();

		bt_init(pk_image1);
		bt_init(pk_image2);
		bt_init(pk_image3);
		bt_init(pk_image4);
		bt_init(pk_image5);

		pk_image_init();
		name_init();
		login_btn();
		add_panel();
		this.setModal(true);

		this.getContentPane().add(panel);
		this.setVisible(true);
	} // make Login_Frame constructor 

	public void var_init() {
		this.panel = new JPanel();
		this.login_title = new JLabel();
		this.pk_image1 = new JButton();
		this.pk_image2 = new JButton();
		this.pk_image3 = new JButton();
		this.pk_image4 = new JButton();
		this.pk_image5 = new JButton();
		this.login_exit = new JButton();
		this.login = new JButton();
		this.name = new JTextField();
	}

	public void panel_init() {
		this.panel.setBounds(0, 0, 400, 300);
		this.panel.setLayout(null);
		this.panel.setBackground(bs_elem.get_content_panel_Color());
	}
// make panel that contains contents 
	public void login_title_init() {
		this.login_title.setBounds(125, 15, 150, 70);
		
		this.login_title.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/login_title.png")));
	}
// insert title image to title JLabel
	public void bt_init(JButton pk) {
		pk.setFocusPainted(false);
		pk.setBorderPainted(false);
		pk.setContentAreaFilled(false);
		this.bt1.add(pk);

	}
	// add button group to panel
	public void name_init() {
		this.name.setHorizontalAlignment(SwingConstants.CENTER);
		this.name.setBounds(105, 202, 150, 30);
		name.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) { 
		        if (name.getText().length() >= 8 ) // reference: limit textfield to 8 characters
		            e.consume(); 				
		        //  https://stackoverflow.com/questions/3519151/how-to-limit-the-number-of-characters-in-jtextfield
		    }  
		});
	}
// make JTextField state that where it is and limit  
	public void pk_image_init() {
		this.pk_image1.setBounds(21, 100, 55, 55);
		this.pk_image2.setBounds(97, 100, 55, 55);
		this.pk_image3.setBounds(173, 100, 55, 55);
		this.pk_image4.setBounds(245, 100, 55, 55);
		this.pk_image5.setBounds(325, 100, 55, 55);

		this.pk_image1.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk1.png")));
		this.pk_image2.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk2.png")));
		this.pk_image3.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk3.png")));
		this.pk_image4.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk4.png")));
		this.pk_image5.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk5.png")));

		this.pk_image1.addActionListener(this);
		this.pk_image2.addActionListener(this);
		this.pk_image3.addActionListener(this);
		this.pk_image4.addActionListener(this);
		this.pk_image5.addActionListener(this);
	}
// insert pokemon head image to button
	public void login_exit_init() {
		this.login_exit.setBounds(355, 10, 35, 35);
		this.login_exit.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/login_exit.png")));
		this.login_exit.setFocusPainted(false);
		this.login_exit.setBorderPainted(false);
		this.login_exit.setContentAreaFilled(false);

		this.login_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == login_exit) {

					System.exit(0);
				}
			}
		});
	}
// insert login image and set the button state
	public void login_btn() {

		this.login.setBounds(250, 185, 75, 65);
		this.login.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/go_icon.png")));

		this.login.setFocusPainted(false);
		this.login.setBorderPainted(false);
		this.login.setContentAreaFilled(false);
		this.login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == login && String_set.info_image != 0) {
					String str = name.getText();
					try {
						int k = Integer.parseInt(str);
						if (str.equals(String.valueOf(User_Info.get_name()))) {
							try {
								FileInputStream fis = new FileInputStream("data.ser");
								ObjectInputStream ois = new ObjectInputStream(fis);
								User_Info user = (User_Info) ois.readObject();
								for (int i = 0; i < 3; i++) {
									String_set.set_test(i, user.get_imsi_testresult(i));
								}
								ois.close();
								setVisible(false);
								// reference: serialization
								// http://mainia.tistory.com/2103
							} catch (IOException | ClassNotFoundException e1) {
								JOptionPane.showMessageDialog(null, "File not exist!\nCreated and saved user's data into new file.");
								setVisible(false);
							}

						}
						else{
							JOptionPane.showMessageDialog(null, "Your ID is not correct!");
						}
					} catch (NumberFormatException ee) {
						JOptionPane.showMessageDialog(null, "Please type only integer");
					}

				}
				else JOptionPane.showMessageDialog(null, "Please selcet the image that you want!");
			}
		});

	}
// insert login image and set the button state. when click the button, pop up the error message or login to the program depending on textField state
	public void add_panel() {

		this.panel.add(this.login_title);
		this.panel.add(this.pk_image1);
		this.panel.add(this.pk_image2);
		this.panel.add(this.pk_image3);
		this.panel.add(this.pk_image4);
		this.panel.add(this.pk_image5);
		this.panel.add(this.name);
		this.panel.add(this.login_exit);
		this.panel.add(this.login);

	}
// add panel
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pk_image1) {
			this.pk_image1.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk1.png")));
			this.pk_image2.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk2g.png")));
			this.pk_image3.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk3g.png")));
			this.pk_image4.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk4g.png")));
			this.pk_image5.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk5g.png")));
			String_set.info_image = 1;
		} else if (e.getSource() == pk_image2) {
			this.pk_image1.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk1g.png")));
			this.pk_image2.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk2.png")));
			this.pk_image3.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk3g.png")));
			this.pk_image4.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk4g.png")));
			this.pk_image5.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk5g.png")));
			String_set.info_image = 2;

		} else if (e.getSource() == pk_image3) {
			this.pk_image1.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk1g.png")));
			this.pk_image2.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk2g.png")));
			this.pk_image3.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk3.png")));
			this.pk_image4.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk4g.png")));
			this.pk_image5.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk5g.png")));
			String_set.info_image = 3;

		} else if (e.getSource() == pk_image4) {
			pk_image1.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk1g.png")));
			pk_image2.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk2g.png")));
			pk_image3.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk3g.png")));
			pk_image4.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk4.png")));
			pk_image5.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk5g.png")));
			String_set.info_image = 4;
		} else if (e.getSource() == pk_image5) {
			this.pk_image1.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk1g.png")));
			this.pk_image2.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk2g.png")));
			this.pk_image3.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk3g.png")));
			this.pk_image4.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk4g.png")));
			this.pk_image5.setIcon(new ImageIcon(Login_Frame.class.getResource("/Login_Frame/pk5.png")));
			String_set.info_image = 5;
		}
	}
// if click the one pokemon head image the other pokemon head images change the color
}
