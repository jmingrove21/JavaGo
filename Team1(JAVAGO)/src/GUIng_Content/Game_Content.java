package GUIng_Content;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import GUIng.GUI;
import GUIng_Etc.Base_Element;
import GUIng_Select.Game_Select;
// Game_Content class : when press start button make game_content panel and by using Game_Select class create image. and inheritance the Content_Panel class
public class Game_Content extends Content_Panel {
	Base_Element bs_elem = new Base_Element();
	Game_Select sel = new Game_Select();
//make object Base_Element,Game_Select
	private int user_ball_num = 3; // to count user life points, initiate integer 3
	private int enemy_ball_num = 3; // to count enemy life points, initiate integer 3
	private int count = 1; //to know what question number, initiate integer 1
	private int ch = -1;  //to take chapter, declare int ch
	private JPanel init_panel;// initiate panel

	private ButtonGroup test1 = new ButtonGroup(); /*make ButtonGroup question by question so make 5 ButtonGroup*/
	private ButtonGroup test2 = new ButtonGroup();
	private ButtonGroup test3 = new ButtonGroup();
	private ButtonGroup test4 = new ButtonGroup();
	private ButtonGroup test5 = new ButtonGroup();
	
	private JLabel question_box; //make question box label
	private JLabel answer_box; //make answer box label
	private JButton attack; // make attack button

	private JLabel user_ball1;  /* make JLabel to identify user life points which are shown by monster ball*/
	private JLabel user_ball2;
	private JLabel user_ball3;

	private JLabel enemy_ball1; /* make JLabel to identify enemy life points which are shown by monster ball*/
	private JLabel enemy_ball2;
	private JLabel enemy_ball3;



	public Game_Content() {

		var_init();
		panel_init();
		box_init();
		user_monsterball_init();
		enemy_monsterball_init();
		add_panel();

	}
// make constructor with some method that work game
	public void var_init() {
		this.question_box = new JLabel();
		this.answer_box = new JLabel();
		this.attack = new JButton();
		this.user_ball1 = new JLabel();
		this.user_ball2 = new JLabel();
		this.user_ball3 = new JLabel();
		this.enemy_ball1 = new JLabel();
		this.enemy_ball2 = new JLabel();
		this.enemy_ball3 = new JLabel();

	}
// make content in panel
	public void attack_img_init(int ch) {
		this.attack = new JButton();

		this.attack.setBounds(530, 580, 172, 52);
		this.attack.setPreferredSize(new Dimension(12, 12));
		this.attack.setMinimumSize(new Dimension(1, 12));
		this.attack.setBorderPainted(false);
		this.attack.setContentAreaFilled(false);
		this.attack.setFocusPainted(false);
		this.attack.setInheritsPopupMenu(false);
this.add(attack);
		this.attack.setIcon(new ImageIcon(GUI.class.getResource("/Game/attack_icon.png")));
		/*make attack button image*/
		this.attack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				switch (count) {
				case 1: {
					if (test1.isSelected(null)) {
						JOptionPane.showMessageDialog(null, "Please click the answer!!");
						break;
					} else {
						count++;
						visible_check(ch, 0, false);

						if (sel.get_select(ch, 0, 0).isSelected() == true
								&& sel.get_select(ch, 0, 0).getText().equals("1")) {
							enemy_ball_num--;
							visible_check(ch, 1, true);
							break;

						} else if (sel.get_select(ch, 0, 1).isSelected() == true
								&& sel.get_select(ch, 0, 1).getText().equals("1")) {
							enemy_ball_num--;
							visible_check(ch, 1, true);

							break;
						} else if (sel.get_select(ch, 0, 2).isSelected() == true
								&& sel.get_select(ch, 0, 2).getText().equals("1")) {
							enemy_ball_num--;
							visible_check(ch, 1, true);
							break;
						} else {
							user_ball_num--;
							visible_check(ch, 1, true);
							break;
						}
					}
				}
				case 2: {
					if (test2.isSelected(null)) {
						JOptionPane.showMessageDialog(null, "Please click the answer!!");
						break;

					} else {
						count++;
						visible_check(ch, 1, false);
						if (sel.get_select(ch, 1, 0).isSelected() == true
								&& sel.get_select(ch, 1, 0).getText().equals("1")) {
							enemy_ball_num--;
							visible_check(ch, 2, true);

							break;
						} else if (sel.get_select(ch, 1, 1).isSelected() == true
								&& sel.get_select(ch, 1, 1).getText().equals("1")) {
							enemy_ball_num--;
							visible_check(ch, 2, true);

							break;
						} else if (sel.get_select(ch, 1, 2).isSelected() == true
								&& sel.get_select(ch, 1, 2).getText().equals("1")) {
							enemy_ball_num--;
							visible_check(ch, 2, true);

							break;
						} else {
							user_ball_num--;
							visible_check(ch, 2, true);

							break;
						}
					}
				}
				case 3: {
					if (test3.isSelected(null)) {
						JOptionPane.showMessageDialog(null, "Please click the answer!!");
						break;

					} else {
						count++;
						visible_check(ch, 2, false);

						if (sel.get_select(ch, 2, 0).isSelected() == true
								&& sel.get_select(ch, 2, 0).getText().equals("1")) {
							enemy_ball_num--;
							if (enemy_ball_num != 0)
								visible_check(ch, 3, true);
							break;
						} else if (sel.get_select(ch, 2, 1).isSelected() == true
								&& sel.get_select(ch, 2, 1).getText().equals("1")) {
							enemy_ball_num--;
							if (enemy_ball_num != 0)
								visible_check(ch, 3, true);
							break;
						} else if (sel.get_select(ch, 2, 2).isSelected() == true
								&& sel.get_select(ch, 2, 2).getText().equals("1")) {
							enemy_ball_num--;
							if (enemy_ball_num != 0)
								visible_check(ch, 3, true);
							break;
						} else {
							user_ball_num--;
							if (user_ball_num != 0)
								visible_check(ch, 3, true);
							break;
						}
					}
				}
				case 4: {
					if (test4.isSelected(null)) {
						JOptionPane.showMessageDialog(null, "Please click the answer!!");
						break;
					} else {
						count++;
						visible_check(ch, 3, false);
						visible_check(ch, 4, true);

						if (sel.get_select(ch, 3, 0).isSelected() == true
								&& sel.get_select(ch, 3, 0).getText().equals("1")) {
							enemy_ball_num--;
							if (enemy_ball_num != 0)
								visible_check(ch, 4, true);
							break;
						} else if (sel.get_select(ch, 3, 1).isSelected() == true
								&& sel.get_select(ch, 3, 1).getText().equals("1")) {
							enemy_ball_num--;
							if (enemy_ball_num != 0)
								visible_check(ch, 4, true);
							break;
						} else if (sel.get_select(ch, 3, 2).isSelected() == true
								&& sel.get_select(ch, 3, 2).getText().equals("1")) {
							enemy_ball_num--;
							if (enemy_ball_num != 0)
								visible_check(ch, 4, true);
							break;
						} else {
							user_ball_num--;
							if (user_ball_num != 0)
								visible_check(ch, 4, true);
							break;
						}
					}
				}
				case 5: {
					if (test5.isSelected(null)) {
						JOptionPane.showMessageDialog(null, "Please click the answer!!");
						break;

					} else {
						if (sel.get_select(ch, 4, 0).isSelected() == true
								&& sel.get_select(ch, 4, 0).getText().equals("1")) {
							enemy_ball_num--;
							break;
						} else if (sel.get_select(ch, 4, 1).isSelected() == true
								&& sel.get_select(ch, 4, 1).getText().equals("1")) {
							enemy_ball_num--;
							break;
						} else if (sel.get_select(ch, 4, 2).isSelected() == true
								&& sel.get_select(ch, 4, 2).getText().equals("1")) {
							enemy_ball_num--;
							break;
						} else {
							user_ball_num--;
							break;
						}
					}
				}
				}
				ball_visible_setting();
				//in switch case sentence there is logic that change question, answer life point image
	
				if (((!user_ball1.isVisible()) && (!user_ball2.isVisible()) && (!user_ball3.isVisible()))) {
					int result1 = JOptionPane.showConfirmDialog(null, "You Lose!!", "GAME OVER",
							JOptionPane.CLOSED_OPTION);
					if (result1 == JOptionPane.CLOSED_OPTION || result1 == JOptionPane.OK_OPTION) {
						Game_Content.this.removeAll();
						Game_Content.this.clear();
						bs_elem.set_now_panel(Game_Content.this);
						bs_elem.set_main_panel(init_panel);
						bs_elem.back();

					}
				} else if (((!enemy_ball1.isVisible()) && (!enemy_ball2.isVisible()) && (!enemy_ball3.isVisible()))) {

					int result2 = JOptionPane.showConfirmDialog(null, "You Win!!", "WINNER", JOptionPane.CLOSED_OPTION);
					if (result2 == JOptionPane.CLOSED_OPTION || result2 == JOptionPane.OK_OPTION) {
						Game_Content.this.removeAll();
						Game_Content.this.clear();
						bs_elem.set_now_panel(Game_Content.this);
						bs_elem.set_main_panel(init_panel);
						bs_elem.back();
					}
					//in if-else sentence pop up the win or lose page bt using monster ball isVisible state
				}
			}
		});
	}

	public void set_init_panel(JPanel init) {
		this.init_panel = init;
	}

	private void box_init() {
		this.question_box.setBounds(4, 0, 722, 208);
		this.question_box.setPreferredSize(new Dimension(12, 12));
		this.question_box.setMinimumSize(new Dimension(1, 12));
		this.question_box.setInheritsPopupMenu(false);
		this.question_box.setIcon(new ImageIcon(GUI.class.getResource("/Game/G_qbox_img.png")));

		this.answer_box.setBounds(4, 607, 722, 208);
		this.answer_box.setPreferredSize(new Dimension(12, 12));
		this.answer_box.setMinimumSize(new Dimension(1, 12));
		this.answer_box.setInheritsPopupMenu(false);
		this.answer_box.setIcon(new ImageIcon(GUI.class.getResource("/Game/G_abox_img.png")));

	}//make question_box and answer_box image

	
	public void panel_init() {
		super.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		super.setBackground(bs_elem.get_content_panel_Color());
	} //make contents panel

	public void panel_detail_init(int ch, int num) {
		sel.get_question(ch, num).setBounds(10, 0, 722, 208);
		sel.get_select(ch, num, 0).setBounds(35, 650, 692, 56);
		sel.get_select(ch, num, 1).setBounds(35, 700, 692, 56);
		sel.get_select(ch, num, 2).setBounds(35, 750, 692, 56);

		for (int i = 0; i < 3; i++) {
			sel.get_select(ch, num, i).setPreferredSize(new Dimension(12, 12));
			sel.get_select(ch, num, i).setMinimumSize(new Dimension(1, 12));
			sel.get_select(ch, num, i).setBorderPainted(false);
			sel.get_select(ch, num, i).setContentAreaFilled(false);
			sel.get_select(ch, num, i).setFocusPainted(false);
			sel.get_select(ch, num, i).setInheritsPopupMenu(false);
		}
		if (num == 4) {
			test5.add(sel.get_select(ch, num, 0));
			test5.add(sel.get_select(ch, num, 1));
			test5.add(sel.get_select(ch, num, 2));
		} else if (num == 3) {
			test4.add(sel.get_select(ch, num, 0));
			test4.add(sel.get_select(ch, num, 1));
			test4.add(sel.get_select(ch, num, 2));
		} else if (num == 2) {
			test3.add(sel.get_select(ch, num, 0));
			test3.add(sel.get_select(ch, num, 1));
			test3.add(sel.get_select(ch, num, 2));
		} else if (num == 1) {
			test2.add(sel.get_select(ch, num, 0));
			test2.add(sel.get_select(ch, num, 1));
			test2.add(sel.get_select(ch, num, 2));
		} else if (num == 0) {
			test1.add(sel.get_select(ch, num, 0));
			test1.add(sel.get_select(ch, num, 1));
			test1.add(sel.get_select(ch, num, 2));

		}

		for (int i = 0; i < 3; i++)
			super.add(sel.get_select(ch, num, i));

		super.add(sel.get_question(ch, num));
		super.add(sel.get_enemy(ch));
		super.add(sel.get_user(ch));
		super.add(sel.get_map(ch));
	}// insert image to Buttongroup by using game_select class and make answer image with 'for' sentence

	public void first_panel_init(int ch) {
		this.panel_detail_init(ch, 0);
		sel.get_map(ch).setBounds(0, 208, 802, 399);
		sel.get_user(ch).setBounds(0, 208, 802, 399);
		sel.get_enemy(ch).setBounds(0, 208, 802, 399);

		super.add(sel.get_enemy(ch));
		super.add(sel.get_user(ch));
		super.add(sel.get_map(ch));

	}
	//make map, character image in panel by using game_select class 

	public void next_panel_init(int ch, int num) {

		this.panel_detail_init(ch, num);
		this.visible_check(ch, num, false);

	}
	
	public void visible_check(int ch, int num, boolean t) {
		sel.get_question(ch, num).setVisible(t);
		for (int i = 0; i < 3; i++)
			sel.get_select(ch, num, i).setVisible(t);
	} //make image which is called by using game_select class state isVisible true

	private void enemy_monsterball_init() {

		this.enemy_ball1.setBounds(30, 220, 52, 49);
		this.enemy_ball1.setPreferredSize(new Dimension(12, 12));
		this.enemy_ball1.setMinimumSize(new Dimension(1, 12));
		this.enemy_ball1.setInheritsPopupMenu(false);
		this.enemy_ball1.setIcon(new ImageIcon(GUI.class.getResource("/Game/eb1.png")));

		this.enemy_ball2.setBounds(82, 220, 52, 49);
		this.enemy_ball2.setPreferredSize(new Dimension(12, 12));
		this.enemy_ball2.setMinimumSize(new Dimension(1, 12));
		this.enemy_ball2.setInheritsPopupMenu(false);
		this.enemy_ball2.setIcon(new ImageIcon(GUI.class.getResource("/Game/eb2.png")));

		this.enemy_ball3.setBounds(134, 220, 52, 49);
		this.enemy_ball3.setPreferredSize(new Dimension(12, 12));
		this.enemy_ball3.setMinimumSize(new Dimension(1, 12));
		this.enemy_ball3.setInheritsPopupMenu(false);
		this.enemy_ball3.setIcon(new ImageIcon(GUI.class.getResource("/Game/eb3.png")));

	}// make enemy_ball image

	private void user_monsterball_init() {

		this.user_ball1.setBounds(565, 490, 52, 49);
		this.user_ball1.setPreferredSize(new Dimension(12, 12));
		this.user_ball1.setMinimumSize(new Dimension(1, 12));
		this.user_ball1.setInheritsPopupMenu(false);
		this.user_ball1.setIcon(new ImageIcon(GUI.class.getResource("/Game/mb1.png")));

		this.user_ball2.setBounds(617, 490, 52, 49);
		this.user_ball2.setPreferredSize(new Dimension(12, 12));
		this.user_ball2.setMinimumSize(new Dimension(1, 12));
		this.user_ball2.setInheritsPopupMenu(false);
		this.user_ball2.setIcon(new ImageIcon(GUI.class.getResource("/Game/mb2.png")));

		this.user_ball3.setBounds(669, 490, 52, 49);
		this.user_ball3.setPreferredSize(new Dimension(12, 12));
		this.user_ball3.setMinimumSize(new Dimension(1, 12));
		this.user_ball3.setInheritsPopupMenu(false);
		this.user_ball3.setIcon(new ImageIcon(GUI.class.getResource("/Game/mb3.png")));

	}// make user_ball image

	public void ball_visible_setting() {
		switch (user_ball_num) {
		case 0: {
			user_ball1.setVisible(false);
			user_ball2.setVisible(false);
			user_ball3.setVisible(false);
			break;
		}
		case 1: {
			user_ball1.setVisible(true);
			user_ball2.setVisible(false);
			user_ball3.setVisible(false);
			break;
		}
		case 2: {
			user_ball1.setVisible(true);
			user_ball2.setVisible(true);
			user_ball3.setVisible(false);
			break;
		}
		case 3: {
			user_ball1.setVisible(true);
			user_ball2.setVisible(true);
			user_ball3.setVisible(true);
			break;
		}

		}
		switch (enemy_ball_num) {
		case 0: {
			enemy_ball1.setVisible(false);
			enemy_ball2.setVisible(false);
			enemy_ball3.setVisible(false);
			break;
		}
		case 1: {
			enemy_ball1.setVisible(true);
			enemy_ball2.setVisible(false);
			enemy_ball3.setVisible(false);
			break;
		}
		case 2: {
			enemy_ball1.setVisible(true);
			enemy_ball2.setVisible(true);
			enemy_ball3.setVisible(false);
			break;
		}
		case 3: {
			enemy_ball1.setVisible(true);
			enemy_ball2.setVisible(true);
			enemy_ball3.setVisible(true);
			break;
		}
		}

	}
	//By using integer variables which are changed in attack button, change the monster ball number

	public void clear() {
		super.removeAll();
		sel = new Game_Select();
		enemy_ball_num = 3;
		user_ball_num = 3;
		count = 1;

		var_init();
		enemy_monsterball_init();
		user_monsterball_init();
		box_init();
		ball_visible_setting();
	}// clear all , call var_init() ,enemy_monsterball_init(), user_monsterball_init(), box_init() and reset ball visible State.


	public void add_panel() {
		super.add(this.attack);
		super.add(this.user_ball1);
		super.add(this.user_ball2);
		super.add(this.user_ball3);
		super.add(this.enemy_ball1);
		super.add(this.enemy_ball2);
		super.add(this.enemy_ball3);
		super.add(this.question_box);
		super.add(this.answer_box);

	}
	// can see in the panel by use this method
	
	
	public ButtonGroup getTest1() {
		return test1;
	}

	public void setTest1(ButtonGroup test1) {
		this.test1 = test1;
	}

	public ButtonGroup getTest2() {
		return test2;
	}

	public void setTest2(ButtonGroup test2) {
		this.test2 = test2;
	}

	public ButtonGroup getTest3() {
		return test3;
	}

	public void setTest3(ButtonGroup test3) {
		this.test3 = test3;
	}

	public ButtonGroup getTest4() {
		return test4;
	}

	public void setTest4(ButtonGroup test4) {
		this.test4 = test4;
	}

	public ButtonGroup getTest5() {
		return test5;
	}

	public void setTest5(ButtonGroup test5) {
		this.test5 = test5;
	}
	/* make getter and setter to use in Game_init_Panel class*/

}