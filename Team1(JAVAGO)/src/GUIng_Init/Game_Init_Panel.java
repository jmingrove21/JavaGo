package GUIng_Init;

import GUIng.GUI;
import GUIng_Content.Game_Content;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
// Game_Init_Panel class  : when press game button make game panel that inheritance the Panel_Code class
public class Game_Init_Panel extends Panel_Code {

	private JPanel init_panel; // make init_panel panel
	private JLabel rocket_image; //make rocket_image label
	private JLabel info_image; //make info_image label
	private JButton start_image; //make start_image button
	private JLabel game_title; //make game_title label
	private int main_ch; // to take chapter, declare int main_ch
//  
	public Game_Content gi = new Game_Content();// make Game_Content object

	public Game_Init_Panel(JPanel main_panel) {
		var_init(main_panel);
		game_panel_init();
		rocket_image_init();
		info_image_init();
		start_image_init();
		game_title_init();
		content_panel_init();
		this.add_panel();

	}// make constructor with some method that make game panel

	public void var_init(JPanel main_panel) {
		super.main_panel = main_panel;
		this.init_panel = new JPanel();
		this.rocket_image = new JLabel();
		this.info_image = new JLabel();
		this.start_image = new JButton();
		this.game_title = new JLabel();

		bs_elem.set_now_panel(panel_code);
		bs_elem.set_main_panel(main_panel);
	}// make content in panel can use Base_Element class because inheritance the Panel_Code

	public void game_panel_init() {
		this.init_panel.setBounds(0, 133, 750, 832);
		this.init_panel.setBackground(bs_elem.get_Color());
		this.init_panel.setVisible(true);
		this.init_panel.setLayout(null);
	} //make panel image

	public void rocket_image_init() {
		this.rocket_image.setBounds(270, 217, 241, 390);
		this.rocket_image.setPreferredSize(new Dimension(12, 12));
		this.rocket_image.setMinimumSize(new Dimension(1, 12));
		this.rocket_image.setInheritsPopupMenu(false);
		this.rocket_image.setIcon(new ImageIcon(GUI.class.getResource("/Game/rocket_image.png")));

	} //make 2 human image

	public void info_image_init() {
		this.info_image.setBounds(150, 617, 500, 75);
		this.info_image.setPreferredSize(new Dimension(12, 12));
		this.info_image.setMinimumSize(new Dimension(1, 12));
		this.info_image.setInheritsPopupMenu(false);
		this.info_image.setIcon(new ImageIcon(GUI.class.getResource("/Game/info_image.png")));

	}//make information of game image 

	public void start_image_init() {
		this.start_image.setBounds(300, 717, 144, 109);
		this.start_image.setPreferredSize(new Dimension(12, 12));
		this.start_image.setMinimumSize(new Dimension(1, 12));
		this.start_image.setBorderPainted(false);
		this.start_image.setContentAreaFilled(false);
		this.start_image.setFocusPainted(false);
		this.start_image.setInheritsPopupMenu(false);
		this.start_image.setIcon(new ImageIcon(GUI.class.getResource("/Game/start_image.png")));
		this.start_image.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				init_panel.setVisible(false);
				gi.clear();
				gi.add_panel();
				gi.attack_img_init(main_ch);
				gi.getTest1().clearSelection();
				gi.getTest2().clearSelection();
				gi.getTest3().clearSelection();
				gi.getTest4().clearSelection();
				gi.getTest5().clearSelection();
				for (int i = 4; i > 0; i--) {
					gi.panel_detail_init(main_ch, i);
					gi.next_panel_init(main_ch, i);

				}
				gi.panel_detail_init(main_ch, 0);
				gi.first_panel_init(main_ch);
				gi.set_init_panel(init_panel);
				gi.setVisible(true);

			}
		});
	}//make start button image and when click it , can see content image and initiate button group that is in Game_Content

	public void game_title_init() {
		this.game_title.setBounds(280, 77, 180, 89);
		this.game_title.setPreferredSize(new Dimension(12, 12));
		this.game_title.setMinimumSize(new Dimension(1, 12));
		this.game_title.setInheritsPopupMenu(false);
		this.game_title.setIcon(new ImageIcon(GUI.class.getResource("/Game/game_title.png")));

	}// make game title image

	public void content_panel_init() {
		this.init_panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.init_panel.setBounds(0, 133, 750, 832);
		this.init_panel.setBackground(bs_elem.get_Color());
		this.init_panel.setLayout(null);
		this.init_panel.setVisible(true);
	}// set the contents area

	@Override
	public void add_panel() {
		// TODO Auto-generated method stub
		init_panel.add(this.rocket_image);
		init_panel.add(this.info_image);
		init_panel.add(this.start_image);
		init_panel.add(this.game_title);
		panel_code.add(init_panel);
		super.panel_code.add(gi);

	}	// can see in the panel by use this method

	@Override
	public void set_init_state() {
		// TODO Auto-generated method stub
		init_panel.setVisible(true);
	}

	public JButton get_start_btn() {
		return this.start_image;
	}

	public void set_ch(int main_ch) {
		this.main_ch = main_ch - 1;

	}
//make getter and setter to use another class
}
