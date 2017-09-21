package GUIng;
/*Left_Main_Panel class
 *Usage : left main panel in initial page
 *  
 * */

import java.awt.Insets;

import javax.swing.*;

import GUIng_Etc.Base_Element;
import GUIng_Etc.String_set;

public class Left_Main_Panel extends JPanel {
	// private JPanel left_panel; //left panel

	private JLabel lectureindex; // Lecture Index Label in upper side of panel

	private JButton chapter1; // chapter 1 button
	private JButton chapter2; // chapter 2 button
	private JButton chapter3; // chapter 3 button

	Base_Element bs_elem = new Base_Element();

	public Left_Main_Panel() {
		var_init();
		left_panel_init();
		lectureindex_init();
		chapter1_init();
		chapter2_init();
		chapter3_init();
		this.add_left_panel();
	}

	public void var_init() {
		this.lectureindex = new JLabel();
	}

	// left_panel_init(): setting panel including 3 chapter buttons in initial panel
	public void left_panel_init() {
		this.setBounds(30, 325, 315, 605);
		this.setBackground(bs_elem.get_Color());
		this.setLayout(null);
	}

	// lectureindex_init(): setting lecture index label above the chapter buttons
	public void lectureindex_init() {
		lectureindex.setBounds(0, 0, 315, 55);
		lectureindex.setHorizontalAlignment(SwingConstants.CENTER);
		lectureindex.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/lectureindex.png")));
	}

	// chapter1_init(): implementing initial setting of chapter1 button
	public void chapter1_init() {
		this.chapter1 = new JButton();
		this.chapter1.setBorderPainted(false);
		this.chapter1.setMargin(new Insets(2, 14, 2, -1));
		this.chapter1.setBounds(10, 86, 290, 155);
		this.chapter1.setFocusPainted(false);
		this.chapter1.setContentAreaFilled(false);

	}

	// chapter2_init(): implementing initial setting of chapter2 button
	public void chapter2_init() {
		this.chapter2 = new JButton();
		this.chapter2.setMargin(new Insets(2, 14, 2, 0));
		this.chapter2.setBounds(10, 263, 290, 155);
		this.chapter2.setBorderPainted(false);
		this.chapter2.setFocusPainted(false);
		this.chapter2.setContentAreaFilled(false);
	}

	// chapter3_init(): implementing initial setting of chapter3 button
	public void chapter3_init() {
		this.chapter3 = new JButton();
		this.chapter3.setMargin(new Insets(2, 14, 2, 0));
		this.chapter3.setBounds(10, 440, 290, 155);
		this.chapter3.setFocusPainted(false);
		this.chapter3.setContentAreaFilled(false);
		this.chapter3.setBorderPainted(false);
	}

	//add_left_panel(): add contents into panel
	public void add_left_panel() {
		this.add(lectureindex);
		this.add(chapter1);
		this.add(chapter2);
		this.add(chapter3);
	}

	// get_lectureindex(): lecture index label getter.
	public JLabel get_lectureindex() {
		return this.lectureindex;
	}

	// get_chapter1_btn(): chapter 1 button getter setting colored_score_bar image with test score got from String_set
	public JButton get_chapter1_btn() {
		if (String_set.get_test(0) == 0)
			this.chapter1.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH1.png")));
		else if (String_set.get_test(0) == 1)
			this.chapter1.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH1-2.png")));
		else if (String_set.get_test(0) == 2)
			this.chapter1.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH1-4.png")));
		else if (String_set.get_test(0) == 3)
			this.chapter1.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH1-6.png")));
		else if (String_set.get_test(0) == 4)
			this.chapter1.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH1-8.png")));
		else if (String_set.get_test(0) == 5)
			this.chapter1.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH1-10.png")));
		else
			this.chapter1.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH1.png")));
		return this.chapter1;
	}

	// get_chapter2_btn(): chapter 2 button getter setting colored_score_bar image with test score got from String_set
	public JButton get_chapter2_btn() {
		if (String_set.get_test(1) == 0)
			this.chapter2.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH2.png")));
		else if (String_set.get_test(1) == 1)
			this.chapter2.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH2-2.png")));
		else if (String_set.get_test(1) == 2)
			this.chapter2.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH2-4.png")));
		else if (String_set.get_test(1) == 3)
			this.chapter2.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH2-6.png")));
		else if (String_set.get_test(1) == 4)
			this.chapter2.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH2-8.png")));
		else if (String_set.get_test(1) == 5)
			this.chapter2.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH2-10.png")));
		else
			this.chapter2.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH2.png")));
		return this.chapter2;
	}

	// get_chapter3_btn(): chapter 3 button getter setting colored_score_bar image with test score got from String_set
	public JButton get_chapter3_btn() {
		if (String_set.get_test(2) == 0)
			this.chapter3.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH3.png")));
		else if (String_set.get_test(2) == 1)
			this.chapter3.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH3-2.png")));
		else if (String_set.get_test(2) == 2)
			this.chapter3.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH3-4.png")));
		else if (String_set.get_test(2) == 3)
			this.chapter3.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH3-6.png")));
		else if (String_set.get_test(2) == 4)
			this.chapter3.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH3-8.png")));
		else if (String_set.get_test(2) == 5)
			this.chapter3.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH3-10.png")));
		else
			this.chapter3.setIcon(new ImageIcon(GUI.class.getResource("/Left_Main/CH3.png")));
		return this.chapter3;
	}
}
