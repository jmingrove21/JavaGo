package GUIng_Select;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import GUIng_Etc.Base_Element;
// Game_Select class : make question, answer, map, character(user, enemy) to use in Game_Content class
public class Game_Select {
	private int chapter, g, c = 0; // chapter, game_question, selections variable
	private JLabel[] map = new JLabel[3]; // map label
	private JLabel[] user = new JLabel[3]; // user character label
	private JLabel[] enemy = new JLabel[3]; // enemy character label
	private JLabel[][] question = new JLabel[3][5]; // game question label
	private JCheckBox[][][] select = new JCheckBox[3][5][3]; // selections
																// check box
	private ImageIcon[] game_map_img = new ImageIcon[3]; // map image
	private ImageIcon[] game_user_img = new ImageIcon[3]; // user character
															// image
	private ImageIcon[] game_enemy_img = new ImageIcon[3]; // enemy character
															// image
	private ImageIcon[][] game_question_img = new ImageIcon[3][5]; // question
																	// image
	private ImageIcon[][][] game_black = new ImageIcon[3][5][3]; // selection
																	// black
																	// image
	private ImageIcon[][][] game_red = new ImageIcon[3][5][3]; // selection red
																// image

	// TorF: make Answer sheet 
	private int[][][] TorF = { { { 0, 1, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 }, { 0, 1, 0 } },
			{ { 0, 0, 1 }, { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1 } },
			{ { 0, 1, 0 }, { 0,  1, 0 }, { 0, 0, 1 }, { 0, 0, 1 }, { 1, 0, 0 } } };

	Base_Element bs_elem = new Base_Element();

	public Game_Select() {
		this.set_game_black_init();
		this.set_game_red_init();
		this.set_select_init();
		this.set_question_img_init();
		this.set_question_init();
		this.set_map_img_init();
		this.set_user_img_init();
		this.set_enemy_img_init();
		this.set_map_init();
		this.set_user_init();
		this.set_enemy_init();
	}

	// set_game_black_init(): make answer image 
	public void set_game_black_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (g = 0; g < 5; g++) {
				for (c = 0; c < 3; c++) {
					ImageIcon imsi = new ImageIcon(Game_Select.class.getResource("/Game_Select/bl"
							+ String.valueOf(chapter + 1) + String.valueOf(g + 1) + String.valueOf(c + 1) + ".png"));
					this.game_black[chapter][g][c] = imsi;
				}
			}
		}
	}

	// set_game_red_init(): make pressed answer image 
	public void set_game_red_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (g = 0; g < 5; g++) {
				for (c = 0; c < 3; c++) {
					ImageIcon imsi = new ImageIcon(Game_Select.class.getResource("/Game_Select/rd"
							+ String.valueOf(chapter + 1) + String.valueOf(g + 1) + String.valueOf(c + 1) + "1.png"));
					this.game_red[chapter][g][c] = imsi;
				}
			}
		}
	}

	// set_select_init(): sort answer in check box
	public void set_select_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (g = 0; g < 5; g++) {
				for (c = 0; c < 3; c++) {
					JCheckBox im = new JCheckBox();

					im.setSelected(false);
					im.setHorizontalAlignment(SwingConstants.CENTER);
					im.setIcon(game_black[chapter][g][c]); // answer image
					im.setSelectedIcon(game_red[chapter][g][c]); // pressed answer imgae
					im.setText(String.valueOf(TorF[chapter][g][c]));// sort answer sheet
					im.setForeground(bs_elem.get_content_panel_Color());
					this.select[chapter][g][c] = im;
				}
			}
		}
	}

	// set_question_img_init(): make question image
	public void set_question_img_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (g = 0; g < 5; g++) {
				this.game_question_img[chapter][g] = new ImageIcon(Game_Select.class
						.getResource("/Game_Select/q" + String.valueOf(chapter + 1) + String.valueOf(g + 1) + ".png"));
			}
		}
	}

	// set_question_init(): make question label
	public void set_question_init() {
		for (chapter = 0; chapter < 3; chapter++) {
			for (g = 0; g < 5; g++) {
				JLabel tmp = new JLabel();
				tmp.setHorizontalAlignment(SwingConstants.CENTER);
				tmp.setIcon(game_question_img[chapter][g]);// call game_question_img
				this.question[chapter][g] = tmp;
			}
		}
	}

	// set_map_img_init(): make map image
	public void set_map_img_init() {
		for (chapter = 0; chapter < 3; chapter++) {

			this.game_map_img[chapter] = new ImageIcon(
					Game_Select.class.getResource("/Game_Select/mp" + String.valueOf(chapter + 1) + ".png"));

		}
	}

	// set_map_init(): make map label
	public void set_map_init() {
		for (chapter = 0; chapter < 3; chapter++) {

			JLabel tmp = new JLabel();
			tmp.setHorizontalAlignment(SwingConstants.CENTER);
			tmp.setIcon(game_map_img[chapter]); //call game_map_img
			this.map[chapter] = tmp;

		}
	}

	// set_user_img_init():  make user character image
	public void set_user_img_init() {
		for (chapter = 0; chapter < 3; chapter++) {

			this.game_user_img[chapter] = new ImageIcon(
					Game_Select.class.getResource("/Game_Select/user" + String.valueOf(chapter + 1) + ".png"));

		}
	}

	// set_user_init(): make user character label
	public void set_user_init() {
		for (chapter = 0; chapter < 3; chapter++) {

			JLabel tmp = new JLabel();
			tmp.setHorizontalAlignment(SwingConstants.CENTER);
			tmp.setIcon(game_user_img[chapter]);//call game_user_img
			this.user[chapter] = tmp;

		}
	}

	// set_enemy_img_init(): make enemy character image
	public void set_enemy_img_init() {
		for (chapter = 0; chapter < 3; chapter++) {

			this.game_enemy_img[chapter] = new ImageIcon(
					Game_Select.class.getResource("/Game_Select/enemy" + String.valueOf(chapter + 1) + ".png"));

		}
	}

	// set_enemy_init():make enemy character label
	public void set_enemy_init() {
		for (chapter = 0; chapter < 3; chapter++) {

			JLabel tmp = new JLabel();
			tmp.setHorizontalAlignment(SwingConstants.CENTER);
			tmp.setIcon(game_enemy_img[chapter]);// call game_enemy_img
			this.enemy[chapter] = tmp;

		}
	}

	// get_question(int ch, int g): question getter
	public JLabel get_question(int ch, int g) {
		return this.question[ch][g];
	}

	// get_select(int ch, int g, int c) : answer check box getter
	public JCheckBox get_select(int ch, int g, int c) {
		return this.select[ch][g][c];
	}

	// get_map(int ch): map getter.
	public JLabel get_map(int ch) {
		return this.map[ch];
	}

	// get_user(int ch): user character getter
	public JLabel get_user(int ch) {
		return this.user[ch];
	}

	// get_enemy(int ch): enemy character getter
	public JLabel get_enemy(int ch) {
		return this.enemy[ch];
	}
}