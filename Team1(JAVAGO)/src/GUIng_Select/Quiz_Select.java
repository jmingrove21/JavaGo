package GUIng_Select;

/* Quiz_select class
 * Usage : store quiz questions and selections
 * 		
 * 
 * */
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import GUIng_Etc.Base_Element;

public class Quiz_Select {
	private int chapter, sub, q, a = 0; // chapter, sub, question, answer
	private JLabel[][][] question = new JLabel[3][2][3]; // question labels
	private JCheckBox[][][][] select = new JCheckBox[3][2][3][3]; // selection check-box
	private ImageIcon[][][] question_img = new ImageIcon[3][2][3]; // question image icon
	private ImageIcon[][][][] quiz_black = new ImageIcon[3][2][3][3]; // black-tone selection image
	private ImageIcon[][][][] quiz_red = new ImageIcon[3][2][3][3]; // red-tone selection image

	// quiz answer list
	private int[][][][] TorF = {
			{ { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } }, { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, 1 } } },
			{ { { 0, 0, 1 }, { 0, 0, 1 }, { 0, 1, 0 } }, { { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1 } } },
			{ { { 0, 1, 0 }, { 1, 0, 0 }, { 1, 0, 0 } }, { { 0, 0, 1 }, { 0, 1, 0 }, { 0, 1, 0 } } } };

	Base_Element bs_elem = new Base_Element();

	public Quiz_Select() {
		set_quiz_black_init();
		set_quiz_red_init();
		set_select_init();
		set_question_img_init();
		set_question_init();
	}

	// set_quiz_black_init() : save black-tone selection images
	public void set_quiz_black_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (sub = 0; sub < 2; sub++) {
				for (q = 0; q < 3; q++) {
					for (a = 0; a < 3; a++) {
						ImageIcon imsi = new ImageIcon(Quiz_Select.class
								.getResource("/Quiz_select/q" + String.valueOf(chapter + 1) + String.valueOf(sub + 1)
										+ String.valueOf(q + 1) + String.valueOf(a + 1) + ".png"));
						this.quiz_black[chapter][sub][q][a] = imsi;
					}
				}
			}
		}
	}

	// set_quiz_red_init() : save red-tone selection images
	public void set_quiz_red_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (sub = 0; sub < 2; sub++) {
				for (q = 0; q < 3; q++) {
					for (a = 0; a < 3; a++) {
						ImageIcon imsi = new ImageIcon(Quiz_Select.class
								.getResource("/Quiz_select/qr" + String.valueOf(chapter + 1) + String.valueOf(sub + 1)
										+ String.valueOf(q + 1) + String.valueOf(a + 1) + ".png"));
						this.quiz_red[chapter][sub][q][a] = imsi;
					}
				}
			}
		}
	}

	// set_select_init() : save selection check-boxes
	public void set_select_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (sub = 0; sub < 2; sub++) {
				for (q = 0; q < 3; q++) {
					for (a = 0; a < 3; a++) {
						JCheckBox im = new JCheckBox();

						im.setSelected(false);
						im.setHorizontalAlignment(SwingConstants.CENTER);
						im.setIcon(quiz_black[chapter][sub][q][a]); // black-tone image
						im.setSelectedIcon(quiz_red[chapter][sub][q][a]); // red-tone image
						im.setText(String.valueOf(TorF[chapter][sub][q][a]));
						im.setForeground(bs_elem.get_content_panel_Color());
						this.select[chapter][sub][q][a] = im;
					}
				}
			}
		}
	}

	// set_question_img_init() : create question image
	public void set_question_img_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (sub = 0; sub < 2; sub++) {
				for (q = 0; q < 3; q++) {
					this.question_img[chapter][sub][q] = new ImageIcon(
							Quiz_Select.class.getResource("/Quiz_select/question" + String.valueOf(chapter + 1)
									+ String.valueOf(sub + 1) + String.valueOf(q + 1) + ".png"));
				}
			}
		}
	}

	// set_question_init() : create question label
	public void set_question_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (sub = 0; sub < 2; sub++) {
				for (q = 0; q < 3; q++) {
					JLabel tmp = new JLabel();
					tmp.setSize(307, 130);
					tmp.setHorizontalAlignment(SwingConstants.CENTER);
					tmp.setIcon(question_img[chapter][sub][q]);// call question image
					this.question[chapter][sub][q] = tmp;
				}
			}
		}
	}

	// get_question(int ch,int sub, int q) : return question label
	public JLabel get_question(int ch, int sub, int q) {
		return this.question[ch][sub][q];
	}

	// get_select(int ch, int sub, int q, int a) : return selection check-boses
	public JCheckBox get_select(int ch, int sub, int q, int a) {
		return this.select[ch][sub][q][a];
	}
}
