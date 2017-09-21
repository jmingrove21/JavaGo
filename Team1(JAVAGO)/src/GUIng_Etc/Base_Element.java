package GUIng_Etc;

/*
 * Base_Element class
 * Usage : make resuable containers
 * */
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.*;

import GUIng.GUI;
import GUIng.Timer_Set;

public class Base_Element {

	private JLabel title_logo; // initial panel title logo
	private JButton sub_title_logo; // small title logo in panel_code panel
	private JButton main_exit_btn; // program exit button

	private Color background_color; // initial background color
	private Color content_panel_color; // content_panel background color (if necessary)
	private JPanel leg; // connecting panel between initial panel and next
	private JPanel main_panel; // panel to go initial page

	private JPanel now_panel; // current panel on window
	private JPanel panel_code; // panel sized 750*1000 shown when get into contents
	private JButton edit_btn; // edit button in upper left corner of initial page
	private JLabel copyright; // copyright label

	public Timer_Set ts; // create timer class reference variable 
	public Thread ti;
	User_Info user = new User_Info(); // create user's object
	Edit_Frame edit = new Edit_Frame();

	public Base_Element() {
		var_init();
		main_exit_init();
		title_init();
		sub_title_init();
		background_color_init();
		content_color_init();
		edit_btn_init();
		panel_code_init();
		copyright_init();
		ts.tt_init();
	}

	public void var_init() {
		this.panel_code = new JPanel();
		this.title_logo = new JLabel();
		this.sub_title_logo = new JButton();
		this.main_exit_btn = new JButton();
		this.leg = new JPanel();
		this.edit_btn = new JButton();
		this.copyright = new JLabel();
		this.ts = new Timer_Set();
	}

	// edit_btn_init(): editor button
	public void edit_btn_init() {
		this.edit_btn.setIcon(new ImageIcon(GUI.class.getResource("/Base_element/editor.png")));
		this.edit_btn.setBounds(30, 10, 55, 55);
		this.edit_btn.setFocusPainted(false);
		this.edit_btn.setContentAreaFilled(false);
		this.edit_btn.setBorderPainted(false);
		this.edit_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(edit.isVisible()==true){
					
				}else{
					edit.setVisible(true);

				}
			}
		});
	}

	// set panel sized 750*1000 to contain contents
	public void panel_code_init() {
		this.panel_code.setBounds(0, 0, 750, 1000);
		this.panel_code.setBackground(this.background_color);
		this.panel_code.setVisible(false);
		this.panel_code.setLayout(null);
		this.panel_code.add(this.main_exit_btn);
		this.panel_code.add(this.sub_title_logo);
		this.panel_code.add(this.edit_btn);
		this.panel_code.add(this.copyright);
		this.panel_code.add(ts.getTt());
	}

	// title_init(): setting title logo 
	public void title_init() {
		this.title_logo.setIcon(new ImageIcon(GUI.class.getResource("/Base_element/title_icon.png")));
		this.title_logo.setBounds(236, 50, 289, 234);

	}

	// main_exit_init(): set program exit button and add listener
	public void main_exit_init() {
		this.main_exit_btn.setIcon(new ImageIcon(GUI.class.getResource("/Base_element/exit_icon.png")));
		this.main_exit_btn.setBounds(665, 10, 55, 55);
		this.main_exit_btn.setFocusPainted(false);
		this.main_exit_btn.setContentAreaFilled(false);
		this.main_exit_btn.setBorderPainted(false);
		this.main_exit_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					user.imsi();
					FileOutputStream fos = new FileOutputStream("data.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(user);
					oos.close();
					// serialization reference: http://mainia.tistory.com/2103
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "IOException Occured!");
				}
				System.exit(0);
			}
		});
	}

	// set_main_panel(JPanel main_panel): main_panel setter.
	public void set_main_panel(JPanel main_panel) {
		this.main_panel = main_panel;
	}

	// set_now_panel(JPanel now_panel): now_panel setter.
	public void set_now_panel(JPanel now_panel) {
		this.now_panel = now_panel;
	}

	// background_color_init(): set background color
	public void background_color_init() {
		this.background_color = new Color(204, 204, 204);
	}

	// content_panel_color_init(): set contents panel color
	public void content_color_init() {
		this.content_panel_color = new Color(238, 238, 238);
	}

	// copyright_init(): set copyright
	public void copyright_init() {
		this.copyright.setText("Copyright 2017. JavaGoTeam All rights cannot be copied without permission");
		this.copyright.setFont(new Font("±¼¸²", Font.ITALIC, 15));
		this.copyright.setHorizontalAlignment(SwingConstants.CENTER);
		this.copyright.setBounds(0, 975, 750, 20);
	}

	// sub_title_init(): set small title logo, and implement Listener
	public void sub_title_init() {
		this.sub_title_logo.setIcon(new ImageIcon(GUI.class.getResource("/Base_element/sub_title_icon.png")));
		this.sub_title_logo.setBounds(313, 31, 126, 90);
		this.sub_title_logo.setFocusPainted(false);
		this.sub_title_logo.setContentAreaFilled(false);
		this.sub_title_logo.setBorderPainted(false);
		this.sub_title_logo.setBorder(null);

		this.sub_title_logo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				back();
			}
		});
	}

	// back(): add function 'go back to previous page'
	public void back() {
		now_panel.setVisible(false);
		if (main_panel != null)
			main_panel.setVisible(true);

		this.sub_title_logo.setVisible(false);
		this.ts.getTt().setVisible(false);
		this.ts.setKey(false);
	}

	// leg_init(int x, int y): panel connecting initial panel and next panel.
	public void leg_init(int x, int y) {
		this.leg.setVisible(true);
		this.leg.setLayout(null);
		this.leg.setBackground(Color.WHITE);
		this.leg.setBounds(x, y, 100, 40);
	}

	// get_panel_code(): panel_code getter.
	public JPanel get_panel_code() {
		return this.panel_code;
	}

	// get_title_logo(): title_logo getter.
	public JLabel get_title_logo() {
		return this.title_logo;
	}

	// get_main_exit_btn(): main_exit_btn getter.
	public JButton get_main_exit_btn() {
		return this.main_exit_btn;
	}

	// get_sub_title_btn(): sub_title_btn getter.
	public JButton get_sub_title_btn() {
		return this.sub_title_logo;
	}

	// get_Color(): background_color getter.
	public Color get_Color() {
		return this.background_color;
	}

	// get_content_panel_Color(): content_panel_color getter.
	public Color get_content_panel_Color() {
		return this.content_panel_color;
	}

	// get_leg_panel(): leg getter.
	public JPanel get_leg_panel() {
		return this.leg;
	}

	// get_edit_btn(): edit_btn getter.
	public JButton get_edit_btn() {
		return this.edit_btn;
	}

	// get_copyright(): copyright getter.
	public JLabel get_copyright() {
		return this.copyright;
	}

	// get_ts(): Timer_Set object getter.
	public Timer_Set get_ts() {
		return this.ts;
	}

}