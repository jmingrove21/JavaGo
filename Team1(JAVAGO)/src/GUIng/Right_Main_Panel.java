package GUIng;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.*;

import GUIng_Etc.Base_Element;
import GUIng_Etc.String_set;
import GUIng_Etc.User_Info;

/* Right_Main_Panel class
 * Usage : create right main panel in initial panel
 * 
 * 
 * */
public class Right_Main_Panel extends JPanel {
	Base_Element bs_elem = new Base_Element();

	// private JPanel right_panel; // right panel
	private JPanel information_panel; // panel contains user information
	private JLabel myInformation; //  My Information label on top
	private JLabel user_image; // image label got from login information
	private JLabel user_id; // user name label
	private JLabel level; // user grade label
	private JButton restart; // restart button

	public Right_Main_Panel() {
		var_init();
		right_panel_init();
		information_panel();
		myInformation_init();
		user_image_init();
		user_id_init();
		level_init();
		restart_init();
		this.add_right_panel();
	}

	public void var_init() {
		this.information_panel = new JPanel();
		this.myInformation = new JLabel();
		this.user_image = new JLabel();
		this.user_id = new JLabel();
		this.level = new JLabel();
		this.restart = new JButton();
	}

	// right_panel_init(): setting big panel on right side of initial panel
	public void right_panel_init() {
		this.setBounds(405, 325, 315, 605);
		this.setBackground(bs_elem.get_Color());
		this.setLayout(null);
	}

	// information_panel(): setting information panel in right big panel
	public void information_panel() {
		this.information_panel.setBounds(12, 86, 288, 509);
		this.information_panel.setLayout(null);

	}

	// myInformation_init(): set my information label on upper right corner of panel
	public void myInformation_init() {
		this.myInformation.setHorizontalAlignment(SwingConstants.CENTER);
		this.myInformation.setBounds(0, 0, 315, 55);
		this.myInformation.setIcon(new ImageIcon(GUI.class.getResource("/Right_Main/myinformation.png")));

	}

	// user_image_init(): implement image from login information on right panel
	public void user_image_init() {
		if (String_set.info_image == 1)
			this.user_image.setIcon(new ImageIcon(GUI.class.getResource("/Right_Main/pk1b.png")));
		else if (String_set.info_image == 2)
			this.user_image.setIcon(new ImageIcon(GUI.class.getResource("/Right_Main/pk2b.png")));
		else if (String_set.info_image == 3)
			this.user_image.setIcon(new ImageIcon(GUI.class.getResource("/Right_Main/pk3b.png")));
		else if (String_set.info_image == 4)
			this.user_image.setIcon(new ImageIcon(GUI.class.getResource("/Right_Main/pk4b.png")));
		else if (String_set.info_image == 5)
			this.user_image.setIcon(new ImageIcon(GUI.class.getResource("/Right_Main/pk5b.png")));
		this.user_image.setBounds(80, 50, 140, 140);

	}

	// user_id_init(): set saved user's id
	public void user_id_init() {
		this.user_id.setText(String.valueOf(User_Info.get_name()));
		this.user_id.setFont(new Font("Gaduri", Font.BOLD, 20));
		this.user_id.setHorizontalAlignment(SwingConstants.CENTER);
		this.user_id.setBounds(0, 200, 288, 30);

	}

	// level_init(): set saved' user's level
	public void level_init() {
		this.level.setText(User_Info.get_level());
		this.level.setFont(new Font("Gaduri", Font.BOLD, 18));
		this.level.setHorizontalAlignment(SwingConstants.CENTER);
		this.level.setBounds(0, 235, 288, 20);

	}

	// restart_init(): implement restart button on bottom of right panel. click button to reset user information.
	public void restart_init() {
		this.restart.setFocusPainted(false);
		this.restart.setBorderPainted(false);
		this.restart.setContentAreaFilled(false);
		this.restart.setIcon(new ImageIcon(GUI.class.getResource("/Right_Main/restart.png")));
		this.restart.setBounds(101, 350, 86, 74);
		this.restart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				File f = new File("data.ser");
				f.delete();
				int result1 = JOptionPane.showConfirmDialog(null, "Terminating the program to initialize", "Restart",
						JOptionPane.CLOSED_OPTION);
				if (result1 == JOptionPane.CLOSED_OPTION || result1 == JOptionPane.OK_OPTION) {
					System.exit(0);
				}

			}
		});
	}

	//add_right_panel(): add contents into panel
	public void add_right_panel() {
		information_panel.add(this.user_image);
		information_panel.add(this.user_id);
		information_panel.add(this.level);
		information_panel.add(this.restart);
		this.add(this.myInformation);
		this.add(this.information_panel);

	}
}
