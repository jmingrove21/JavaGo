
package GUIng;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GUIng_Content.Content_Panel;
import GUIng_Content.Lecture_Content;
import GUIng_Content.Summary_Content;
import GUIng_Etc.Base_Element;
import GUIng_Etc.Login_Frame;
import GUIng_Init.Game_Init_Panel;
import GUIng_Init.Lecture_Init_Panel;
import GUIng_Init.Panel_Code;
import GUIng_Init.Quiz_Init_Panel;
import GUIng_Init.Test_Init_Panel;



/* GUI class
 * 
 * make frame information and main_panel
 * make every functions works in main_panel
 * 
 * */
public class GUI extends JFrame implements MouseListener {

	Login_Frame login = new Login_Frame();// login frame when program started

	JPanel main_panel = new JPanel();// initial page panel. 750*1000.

	Base_Element bs_elem = new Base_Element(); // call components for panel

	Left_Main_Panel lpanel = new Left_Main_Panel(); // left main panel in initial page
	Right_Main_Panel rpanel = new Right_Main_Panel(); // right main panel in initial page

	// right chapter panele appeared by clicking chapter button on left side of initial page.
	// for convenience, group with chpanel array
	Chapter_Panel ch1panel = new Chapter_Panel(1);
	Chapter_Panel ch2panel = new Chapter_Panel(2);
	Chapter_Panel ch3panel = new Chapter_Panel(3);
	Chapter_Panel[] chpanel = { ch1panel, ch2panel, ch3panel };

	// create lecture, summary, Quiz, Test, Game initial panel. Parameter : get initial page
	Lecture_Init_Panel lecPanel = new Lecture_Init_Panel(main_panel);
	Quiz_Init_Panel quizPanel = new Quiz_Init_Panel(main_panel);
	Test_Init_Panel testPanel = new Test_Init_Panel(main_panel);
	Game_Init_Panel gamePanel = new Game_Init_Panel(main_panel);

	int clicked_ch = -1;// int type variable using chapter value

	/*
	 * GUI() : create and implement frame. call methods of GUI; button click, etc
	 */
	public GUI() {

		this.setSize(750, 1000);
		this.setUndecorated(true);
		this.setResizable(false);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension di = tk.getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int) (di.getWidth() / 2 - di1.getWidth() / 2),
				(int) (di.getHeight() / 2 - di1.getHeight() / 2));
		// size of window, fixing location  cf)http://blog.naver.com/dongho919/130169879884

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);

		this.main_panel_init();
		this.init();

		this.ch_click();

		this.lecture_click(ch1panel);
		this.lecture_click(ch2panel);
		this.lecture_click(ch3panel);

		this.summary_click(ch1panel);
		this.summary_click(ch2panel);
		this.summary_click(ch3panel);

		this.quiz_click(ch1panel);
		this.quiz_click(ch2panel);
		this.quiz_click(ch3panel);

		this.test_click(ch1panel);
		this.test_click(ch2panel);
		this.test_click(ch3panel);

		this.game_click(ch1panel);
		this.game_click(ch2panel);
		this.game_click(ch3panel);

		this.setVisible(true);

	}

	// main_panel_init() : implements initial panel
	public void main_panel_init() {

		this.main_panel.setBounds(0, 0, 750, 1000);
		this.main_panel.setBackground(bs_elem.get_Color());
		this.main_panel.setLayout(null);

		this.main_panel.add(bs_elem.get_title_logo()); // title logo in upper side of initial page
		this.main_panel.add(bs_elem.get_main_exit_btn()); // exit button in upper right side of initial page
		this.main_panel.add(bs_elem.get_edit_btn()); // edit button in upper left side of initial page
		this.main_panel.add(bs_elem.get_copyright()); // copyright button in upper left side on initial panel

		this.main_panel.add(lpanel);
		this.main_panel.add(rpanel);

		this.main_panel.add(ch1panel);
		this.main_panel.add(ch2panel);
		this.main_panel.add(ch3panel);

		this.getContentPane().add(main_panel);
		bs_elem.set_main_panel(main_panel);

		main_panel.add(bs_elem.get_leg_panel()); // label connecting left and right panel when chapter button clicked												// 패널을 연결해주는 label.

		ch1panel.setVisible(false);
		ch2panel.setVisible(false);
		ch3panel.setVisible(false);
	}

	// init(): add lecture, summary, quiz, game, test panel to frame. setVisible(false) state.
	public void init() {
		this.getContentPane().add(lecPanel.get_panel_code());
		this.getContentPane().add(quizPanel.get_panel_code());
		this.getContentPane().add(gamePanel.get_panel_code());
		this.getContentPane().add(testPanel.get_panel_code());
	}

	// ch_click(): mehtod works when click chapter 1,2,3  button
	public void ch_click() {
		lpanel.get_chapter1_btn().addMouseListener(this);
		lpanel.get_chapter2_btn().addMouseListener(this);
		lpanel.get_chapter3_btn().addMouseListener(this);
	}

	// Chapter_btn_update(int i, boolean t): 'setVisible' of panels when click chapter button
	// change state and check which chapter had clicked(clicked_ch).

	public void chapter_btn_update(int i, boolean t) {
		if (t == true) {
			if (i == 1) {
				lpanel.get_chapter1_btn().setEnabled(true);
				lpanel.get_chapter2_btn().setEnabled(!t);
				lpanel.get_chapter3_btn().setEnabled(!t);
				lpanel.get_lectureindex().setEnabled(!t);
				chpanel[i - 1].setVisible(t);
				rpanel.setVisible(!t);
				clicked_ch = 1;

			} else if (i == 2) {
				lpanel.get_chapter1_btn().setEnabled(!t);
				lpanel.get_chapter2_btn().setEnabled(true);
				lpanel.get_chapter3_btn().setEnabled(!t);
				lpanel.get_lectureindex().setEnabled(!t);
				chpanel[i - 1].setVisible(t);
				rpanel.setVisible(!t);
				clicked_ch = 2;
			}

			else if (i == 3) {
				lpanel.get_chapter1_btn().setEnabled(!t);
				lpanel.get_chapter2_btn().setEnabled(!t);
				lpanel.get_chapter3_btn().setEnabled(true);
				lpanel.get_lectureindex().setEnabled(!t);
				chpanel[i - 1].setVisible(t);
				rpanel.setVisible(!t);
				clicked_ch = 3;

			}
		} else {
			lpanel.get_chapter1_btn().setEnabled(true);
			lpanel.get_chapter2_btn().setEnabled(true);
			lpanel.get_chapter3_btn().setEnabled(true);
			lpanel.get_lectureindex().setEnabled(true);
			chpanel[i - 1].setVisible(t);
			rpanel.setVisible(true);
			bs_elem.get_leg_panel().setVisible(t);
			clicked_ch = -1;

		}

	}

	/*
	 * lecture_click(Chapter_Panel ch_pane) use right Chapter_Panel lecture button
	 * check current chapter number with ch_panel clicked_ch. 
	 * if con panel already exist in lecPanel, remove it and newly add
	 */
	public void lecture_click(Chapter_Panel ch_panel) {

		ch_panel.sub_1.get_lecture_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == ch_panel.sub_1.get_lecture_btn()) {
					Content_Panel con = new Lecture_Content(clicked_ch, 1);
					if (lecPanel.get_panel_code().getComponentCount() == 6) {
						lecPanel.get_panel_code().remove(5);
					}
					lecPanel.get_panel_code().add(con);
					clicked_setting(lecPanel);
				}
			}
		});
		ch_panel.sub_2.get_lecture_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == ch_panel.sub_2.get_lecture_btn()) {
					Content_Panel con = new Lecture_Content(clicked_ch, 2);
					if (lecPanel.get_panel_code().getComponentCount() == 6) {
						lecPanel.get_panel_code().remove(5);
					}
					lecPanel.get_panel_code().add(con);
					clicked_setting(lecPanel);
				}
			}
		});
	}

	/*
	 * summary_click(Chapter_Panel ch_panel): use right Chapter_Panel summary button
	 * check current chapter number with ch_panel clicked_ch. 
	 * if con panel already exist in lecPanel, remove it and newly add
	 */
	public void summary_click(Chapter_Panel ch_panel) {

		ch_panel.sub_1.get_summary_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == ch_panel.sub_1.get_summary_btn()) {
					Content_Panel con = new Summary_Content(clicked_ch, 1);
					if (lecPanel.get_panel_code().getComponentCount() == 6) {
						lecPanel.get_panel_code().remove(5);
					}
					lecPanel.get_panel_code().add(con);
					clicked_setting(lecPanel);
				}
			}
		});
		ch_panel.sub_2.get_summary_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == ch_panel.sub_2.get_summary_btn()) {
					Content_Panel con = new Summary_Content(clicked_ch, 2);
					if (lecPanel.get_panel_code().getComponentCount() == 6) {
						lecPanel.get_panel_code().remove(5);
					}
					lecPanel.get_panel_code().add(con);
					clicked_setting(lecPanel);
				}
			}
		});
	}

	/*
	 * quiz_click(Chapter_Panel ch_panel): use quiz button in right Chapter_Panel quiz
	 * check current chapter number with ch_panel clicked_ch. 
	 * call initial quiz panel(quiz_panel).
	 */
	public void quiz_click(Chapter_Panel ch_panel) {
		ch_panel.sub_1.get_quiz_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == ch_panel.sub_1.get_quiz_btn()) {
					quizPanel.set_ch(clicked_ch, 0);
					clicked_setting(quizPanel);
				}
			}
		});
		ch_panel.sub_2.get_quiz_btn().addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == ch_panel.sub_2.get_quiz_btn()) {
					quizPanel.set_ch(clicked_ch, 1);
					clicked_setting(quizPanel);
				}
			}
		});
	}

	/*
	 * game_click(Chapter_Panel ch_panel): use game button in right Chapter_Panel
	 * check current chapter number with ch_panel clicked_ch.  
	 * call initial game panel(gamePanel).
	 */
	public void game_click(Chapter_Panel ch_panel) {

		ch_panel.get_game_btn().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getSource() == ch_panel.get_game_btn()) {
					gamePanel.gi.removeAll();
					gamePanel.set_ch(clicked_ch);
					clicked_setting(gamePanel);
				}
			}
		});
	}

	/*
	 * test_click(Chapter_Panel ch_panel): use game button in right Chapter_Panel test
	 * check current chapter number with ch_panel clicked_ch. 
	 * call initial game panel(testPanel).
	 */
	public void test_click(Chapter_Panel ch_panel) {

		ch_panel.get_test_btn().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				testPanel.set_ch(clicked_ch);
				clicked_setting(testPanel);
			}
		});
	}

	// clicked_setting(Panel_code pc)
    // when it called, 1. set invisible main panel 2. set visible content panels(lecture, etc)
	public void clicked_setting(Panel_Code pc) {
		pc.get_panel_code().setVisible(true);
		pc.set_init_state();
		pc.get_bs_element().get_sub_title_btn().setVisible(true);
		main_panel.setVisible(false);
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		//set function for chapter button
		
		if (e.getSource() == lpanel.get_chapter1_btn()) {
			if (lpanel.get_chapter1_btn().isEnabled() == true && lpanel.get_chapter2_btn().isEnabled() == true
					&& lpanel.get_chapter3_btn().isEnabled() == true) {
				chapter_btn_update(1, true);
				bs_elem.leg_init(320, 468);
			}else if (lpanel.get_chapter1_btn().isEnabled() == false && lpanel.get_chapter2_btn().isEnabled() == true
					&& lpanel.get_chapter3_btn().isEnabled() == false) {
				chapter_btn_update(2, false);
				chapter_btn_update(1, true);
				bs_elem.leg_init(320, 468);

			}else if (lpanel.get_chapter1_btn().isEnabled() == false && lpanel.get_chapter2_btn().isEnabled() == false
					&& lpanel.get_chapter3_btn().isEnabled() == true) {
				chapter_btn_update(3, false);
				chapter_btn_update(1, true);
				bs_elem.leg_init(320, 468);
			}
			
			else if (lpanel.get_chapter1_btn().isEnabled() == true && lpanel.get_chapter2_btn().isEnabled() == false
					&& lpanel.get_chapter3_btn().isEnabled() == false) {
			
				chapter_btn_update(1, false);

			}
		} else if (e.getSource() == lpanel.get_chapter2_btn()) {
			if (lpanel.get_chapter1_btn().isEnabled() == true && lpanel.get_chapter2_btn().isEnabled() == true
					&& lpanel.get_chapter3_btn().isEnabled() == true) {

				chapter_btn_update(2, true);
				bs_elem.leg_init(320, 645);

			} else if (lpanel.get_chapter1_btn().isEnabled() == false && lpanel.get_chapter2_btn().isEnabled() == true
					&& lpanel.get_chapter3_btn().isEnabled() == false) {
				chapter_btn_update(2, false);
			} else if (lpanel.get_chapter1_btn().isEnabled() == true && lpanel.get_chapter2_btn().isEnabled() == false
					&& lpanel.get_chapter3_btn().isEnabled() == false) {
				chapter_btn_update(1, false);
				chapter_btn_update(2, true);
				bs_elem.leg_init(320, 645);
			} else if (lpanel.get_chapter1_btn().isEnabled() == false && lpanel.get_chapter2_btn().isEnabled() == false
					&& lpanel.get_chapter3_btn().isEnabled() == true) {
				chapter_btn_update(3, false);
				chapter_btn_update(2, true);
				bs_elem.leg_init(320, 645);
			}
		} else if (e.getSource() == lpanel.get_chapter3_btn()) {
			if (lpanel.get_chapter1_btn().isEnabled() == true && lpanel.get_chapter2_btn().isEnabled() == true
					&& lpanel.get_chapter3_btn().isEnabled() == true) {

				chapter_btn_update(3, true);
				bs_elem.leg_init(320, 822);

			} else if (lpanel.get_chapter1_btn().isEnabled() == true && lpanel.get_chapter2_btn().isEnabled() == false
					&& lpanel.get_chapter3_btn().isEnabled() == false) {
				chapter_btn_update(1, false);
				chapter_btn_update(3, true);
				bs_elem.leg_init(320, 822);
			} else if (lpanel.get_chapter1_btn().isEnabled() == false && lpanel.get_chapter2_btn().isEnabled() == true
					&& lpanel.get_chapter3_btn().isEnabled() == false) {
				chapter_btn_update(2, false);
				chapter_btn_update(3, true);
				bs_elem.leg_init(320, 822);
			} else if (lpanel.get_chapter1_btn().isEnabled() == false && lpanel.get_chapter2_btn().isEnabled() == false
					&& lpanel.get_chapter3_btn().isEnabled() == true) {
				chapter_btn_update(3, false);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	
	public static void main(String[] args) {
		//password : 20170612
		GUI main = new GUI();
	}
}