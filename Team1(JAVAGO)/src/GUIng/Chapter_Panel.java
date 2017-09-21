
package GUIng;
/* 
 * Chapter_Panel class
 * 
 * Usage : make right frame came out by clicking chapter1,2,3 button
 *         put frames of sub chapters made in sub_Lecture_Panel
 *         set titles of lectures by String_set class
 * 
 * */

import java.awt.Color;

import javax.swing.*;

import GUIng_Etc.Base_Element;

public class Chapter_Panel extends JPanel {
	Base_Element bs_elem = new Base_Element();

	private JLabel oop_label; // <Object-Oriented Programming> label.
	private JButton test; // test button.
	private JButton game; // game button.
	private int main_ch; // chapter value

	Sub_Chapter_Panel sub_1;
	Sub_Chapter_Panel sub_2;

	public Chapter_Panel(int main_ch) {
		this.main_ch = main_ch;
		var_init();
		chapter_panel_init();
		oop_label_init();
		test_init();
		game_init();
	}

	public void var_init() {

		this.oop_label = new JLabel();
		this.test = new JButton();
		this.game = new JButton();
		this.sub_1 = new Sub_Chapter_Panel(this.main_ch, 1);
		this.sub_2 = new Sub_Chapter_Panel(this.main_ch, 2);
		this.add_panel();
	}

	// chapter_panel_init(): panel set method appears when click chapter button in initial page
	public void chapter_panel_init() {
		this.setBounds(405, 324, 315, 615);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
	}

	// oop_label_init(): <Object-Oriented Programming> label set method
	public void oop_label_init() {
		this.oop_label.setHorizontalAlignment(SwingConstants.CENTER);
		this.oop_label.setBounds(0, 0, 313, 31);
		this.oop_label.setIcon(new ImageIcon(GUI.class.getResource("/Chapter/oop_menu.png")));
	}

	// test_init(): test button set method
	public void test_init() {
		this.test.setIcon(new ImageIcon(GUI.class.getResource("/Chapter/test_icon.png")));
		this.test.setFocusPainted(false);
		this.test.setContentAreaFilled(false);
		this.test.setBorderPainted(false);
		this.test.setBounds(90, 530, 59, 63);
	}

	// game_init(): game button set method
	public void game_init() {
		this.game.setIcon(new ImageIcon(GUI.class.getResource("/Chapter/game_icon.png")));
		this.game.setFocusPainted(false);
		this.game.setContentAreaFilled(false);
		this.game.setBorderPainted(false);
		this.game.setBounds(165, 525, 58, 64);

	}

	// add_panel(): add contents into panel.
	public void add_panel() {

		sub_1.setLocation(42, 100);
		sub_2.setLocation(42, 320);

		this.add(this.oop_label);
		this.add(this.sub_1);
		this.add(this.sub_2);
		this.add(this.test);
		this.add(this.game);

	}

	// get_test_btn(): test button getter.
	public JButton get_test_btn() {
		return this.test;
	}

	// get-game_btn(): game button getter.
	public JButton get_game_btn() {
		return this.game;
	}

}
