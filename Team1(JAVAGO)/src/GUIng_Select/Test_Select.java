package GUIng_Select;

/* Test_Select class
 * Usage : store test questions and selections
 * 		
 * 
 * */
import javax.swing.*;

import GUIng_Etc.Base_Element;

public class Test_Select {
	private int chapter, t, c = 0; // chapter, test_question, answer
	private JLabel[][] question = new JLabel[3][5]; // Use Label for questions
	private JCheckBox[][][] select = new JCheckBox[3][5][3]; // Use Checkbox for checking if selected
	private ImageIcon[][] test_question_img = new ImageIcon[3][5]; // Use ImageIcon for question images 
	private ImageIcon[][][] test_black = new ImageIcon[3][5][3]; // answer list for black (default)
	private ImageIcon[][][] test_red = new ImageIcon[3][5][3]; // answer list for red (selected)

	// Checking for Test answer(1:answer, 0:wrong answer)
	private int[][][] TorF = { { { 0, 0, 1 }, { 0, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 1 } },
			{ { 1, 0, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1 } },
			{ { 0, 0, 1 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 0, 1 } } };

	Base_Element bs_elem = new Base_Element();

	public Test_Select() {

		this.set_test_black_init();
		this.set_test_red_init();
		this.set_select_init();
		this.set_question_img_init();
		this.set_question_init();

	}
	
	//set_test_black_init(): test answer list saving (black images)
	public void set_test_black_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (t = 0; t < 5; t++) {
				for (c = 0; c < 3; c++) {
					ImageIcon imsi = new ImageIcon(Test_Select.class.getResource("/Test_Select/t"
							+ String.valueOf(chapter + 1) + String.valueOf(t + 1) + String.valueOf(c + 1) + ".png"));
					this.test_black[chapter][t][c] = imsi;
				}
			}
		}
	}

	//set_test_red_init(): for selected test answer list saving (red images)
	public void set_test_red_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (t = 0; t < 5; t++) {
				for (c = 0; c < 3; c++) {
					ImageIcon imsi = new ImageIcon(Test_Select.class.getResource("/Test_Select/tr"
							+ String.valueOf(chapter + 1) + String.valueOf(t + 1) + String.valueOf(c + 1) + ".png"));
					this.test_red[chapter][t][c] = imsi;
				}
			}
		}
	}
	
	//set_select_init(): for saving ansewer list at Jcheckbox
	public void set_select_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (t = 0; t < 5; t++) {
				for (c = 0; c < 3; c++) {
					JCheckBox im = new JCheckBox();

					im.setSelected(false);
					im.setHorizontalAlignment(SwingConstants.CENTER);
					im.setIcon(test_black[chapter][t][c]); // black images 
					im.setSelectedIcon(test_red[chapter][t][c]); // red images
																	
					im.setText(String.valueOf(TorF[chapter][t][c]));
					im.setForeground(bs_elem.get_content_panel_Color());
					this.select[chapter][t][c] = im;
				}
			}
		}
	}
	
	//set_question_img_init(): creating for question images. 
	public void set_question_img_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (t = 0; t < 5; t++) {
				this.test_question_img[chapter][t] = new ImageIcon(Test_Select.class.getResource(
						"/Test_Select/test" + String.valueOf(chapter + 1) + String.valueOf(t + 1) + ".png"));
			}
		}
	}

	//set_question_init(): creating for question label. 
	public void set_question_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (t = 0; t < 5; t++) {
				JLabel tmp = new JLabel();
				tmp.setHorizontalAlignment(SwingConstants.CENTER);
				tmp.setIcon(test_question_img[chapter][t]);// ���� �̹��� �ҷ���
				this.question[chapter][t] = tmp;
			}
		}
	}

	//get_question(int ch, int t): question label getter
	public JLabel get_question(int ch, int t) {
		return this.question[ch][t];
	}

	// get_select(int ch, int q, int a) : answers checkbox getter
	public JCheckBox get_select(int ch, int t, int c) {
		return this.select[ch][t][c];
	}
}
