package GUIng_Etc;
/*
 * Edit_Frame class
 * Usage : create panel which shown when edit button clicked
 * */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Edit_Frame extends JDialog {

	private JPanel panel; // edit panel
	private JLabel edit_title; // edit panel title
	private JLabel developer1; // developer1 label
	private JLabel developer2; // developer2 label
	private JLabel developer3; // developer3 label
	private JLabel developer4; // developer4 label
	private JLabel developer5; // developer5 label
	private JButton ok_btn; // ok button
	private Color edit_color;
	// Edit_Frame() : frame setting and method calling constructor 
	public Edit_Frame() {
		this.setUndecorated(true);
		this.setSize(400, 300);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) (di.getWidth() - di1.getWidth()),
				(int) (di.getHeight() - di1.getHeight()));
		this.setAlwaysOnTop(true);
		
		var_init();
		panel_init();
		edit_title_init();
		develop_init();
		ok_btn_init();
		add_panel();
	}

	public void var_init() {
		this.panel = new JPanel();
		this.edit_title = new JLabel();
		this.developer1 = new JLabel();
		this.developer2 = new JLabel();
		this.developer3 = new JLabel();
		this.developer4 = new JLabel();
		this.developer5 = new JLabel();
		this.ok_btn = new JButton();
		this.edit_color=new Color(234,234,234);

	}

	// panel_init(): set panel
	public void panel_init() {
		panel.setBounds(0, 0, 400, 300);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
	}

	// edit_title_init(): set edit_title 
	public void edit_title_init() {
		edit_title.setBounds(125, 20, 150, 70);
		
		edit_title.setIcon(new ImageIcon(Edit_Frame.class.getResource("/Edit_Frame/editby.png")));
	}

	// develop_init(): set developer
	public void develop_init() {
		developer1.setBounds(5, 115, 70, 70);
		developer2.setBounds(85, 115, 70, 70);
		developer3.setBounds(165, 115, 70, 70);
		developer4.setBounds(245, 115, 70, 70);
		developer5.setBounds(325, 115, 70, 70);

		developer1.setIcon(new ImageIcon(Edit_Frame.class.getResource("/Edit_Frame/p1.png")));
		developer2.setIcon(new ImageIcon(Edit_Frame.class.getResource("/Edit_Frame/p2.png")));
		developer3.setIcon(new ImageIcon(Edit_Frame.class.getResource("/Edit_Frame/p3.png")));
		developer4.setIcon(new ImageIcon(Edit_Frame.class.getResource("/Edit_Frame/p4.png")));
		developer5.setIcon(new ImageIcon(Edit_Frame.class.getResource("/Edit_Frame/p5.png")));
	}

	// ok_btn_init(): set ok_button
	public void ok_btn_init() {
		this.ok_btn.setBounds(160, 220, 80, 65);
		this.ok_btn.setIcon(new ImageIcon(Edit_Frame.class.getResource("/Edit_Frame/ok_icon.png")));
		this.ok_btn.setFocusPainted(false);
		this.ok_btn.setBorderPainted(false);
		this.ok_btn.setContentAreaFilled(false);
		this.ok_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
	}

	public void add_panel() {
		panel.add(edit_title);
		panel.add(developer1);
		panel.add(developer2);
		panel.add(developer3);
		panel.add(developer4);
		panel.add(developer5);
		panel.add(ok_btn);
		this.add(panel);
	}
}
