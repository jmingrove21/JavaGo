package GUIng_Content;

/* Quiz_Content class
 * 용도 : 퀴즈버튼 누른 후 스타트 버튼 실행 시 문제화면 패널을 만듬
 * 		Quiz_select class에서 문제들을 가져온다. Content_Panel 상속
 * 		
 * */
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import GUIng.GUI;
import GUIng_Etc.Base_Element;
import GUIng_Init.Quiz_Init_Panel;
import GUIng_Select.Quiz_Select;

public class Quiz_Content extends Content_Panel {
	Base_Element bs_elem = new Base_Element();
	Quiz_Select sel = new Quiz_Select();

	private JLabel clock; // image label for timer
	private JButton submit_btn; // submit button.
	private int ch, sub, result = 0; // chapter, sub chapter, result variables
	private JPanel init_panel; // init panel
	private ButtonGroup quiz1 = new ButtonGroup(); // button group 1
	private ButtonGroup quiz2 = new ButtonGroup(); // button group 2
	private ButtonGroup quiz3 = new ButtonGroup(); // button group 3

	public Quiz_Content(int ch, int sub) {
		this.ch = ch;
		this.sub = sub;
		var_init();
		content_panel_init1();
		clock_init();

	}

	public void var_init() {
		this.clock = new JLabel();
	}

	// clock : make timer
	public void clock_init() {
		this.clock.setIcon(new ImageIcon(Quiz_Init_Panel.class.getResource("/Quiz/clock_" + 1 + ".png")));
		this.clock.setBounds(650, 50, 60, 137);
	}

	// submit_init : create initial submit button and add functions
	public void submit_init(int ch, int sub) {
		this.ch = ch;
		this.sub = sub;
		this.submit_btn.setFocusPainted(false);
		this.submit_btn.setBorderPainted(false);
		this.submit_btn.setContentAreaFilled(false);
		this.submit_btn.setIcon(new ImageIcon(GUI.class.getResource("/Quiz/submit_icon.png")));
		this.submit_btn.setBounds(300, 722, 144, 110);

	}

	// content_panel_init : create panel
	public void content_panel_init1() {
		super.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		super.setBackground(bs_elem.get_content_panel_Color());
		super.add(clock);

		super.setVisible(false);
	}

	// quiz_q_panel: call questions and selects by ch and sub values, and add to panel.
	public void quiz_q_panel(int ch, int sub) {
		this.ch = ch;
		this.sub = sub;
		sel.get_question(ch, sub, 0).setBounds(7, 15, 643, 90);
		sel.get_select(ch, sub, 0, 0).setBounds(7, 105, 643, 40);
		sel.get_select(ch, sub, 0, 1).setBounds(7, 145, 643, 40);
		sel.get_select(ch, sub, 0, 2).setBounds(7, 185, 643, 40);
		quiz1.add(sel.get_select(ch, sub, 0, 0));
		quiz1.add(sel.get_select(ch, sub, 0, 1));
		quiz1.add(sel.get_select(ch, sub, 0, 2));

		super.add(sel.get_question(ch, sub, 0));
		super.add(sel.get_select(ch, sub, 0, 0));
		super.add(sel.get_select(ch, sub, 0, 1));
		super.add(sel.get_select(ch, sub, 0, 2));

		sel.get_question(ch, sub, 1).setBounds(7, 235, 643, 90);
		sel.get_select(ch, sub, 1, 0).setBounds(7, 335, 643, 40);
		sel.get_select(ch, sub, 1, 1).setBounds(7, 375, 643, 40);
		sel.get_select(ch, sub, 1, 2).setBounds(7, 415, 643, 40);

		quiz2.add(sel.get_select(ch, sub, 1, 0));
		quiz2.add(sel.get_select(ch, sub, 1, 1));
		quiz2.add(sel.get_select(ch, sub, 1, 2));

		super.add(sel.get_question(ch, sub, 1));
		super.add(sel.get_select(ch, sub, 1, 0));
		super.add(sel.get_select(ch, sub, 1, 1));
		super.add(sel.get_select(ch, sub, 1, 2));

		sel.get_question(ch, sub, 2).setBounds(7, 465, 643, 90);
		sel.get_select(ch, sub, 2, 0).setBounds(7, 565, 643, 40);
		sel.get_select(ch, sub, 2, 1).setBounds(7, 605, 643, 40);
		sel.get_select(ch, sub, 2, 2).setBounds(7, 645, 643, 40);

		quiz3.add(sel.get_select(ch, sub, 2, 0));
		quiz3.add(sel.get_select(ch, sub, 2, 1));
		quiz3.add(sel.get_select(ch, sub, 2, 2));

		super.add(sel.get_question(ch, sub, 2));
		super.add(sel.get_select(ch, sub, 2, 0));
		super.add(sel.get_select(ch, sub, 2, 1));
		super.add(sel.get_select(ch, sub, 2, 2));

	}

	// submit_click(int ch, int sub): implement submit button and add Listener
	public void submit_click(int ch, int sub) {
		this.submit_btn = new JButton();
		submit_init(ch, sub);
		super.add(submit_btn);
		this.submit_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doSubmit();
			}
		});
	}

	// do_Submit(): use by clicking submit button. score and show result.
	public void doSubmit() {
		if (quiz1.isSelected(null) || quiz2.isSelected(null) || quiz3.isSelected(null))
			JOptionPane.showMessageDialog(null, "There are questions that you didn't solved yet.");
		else {
			for (int q = 0; q < 3; q++) {
				if (sel.get_select(ch, sub, q, 0).isSelected() == true
						&& sel.get_select(ch, sub, q, 0).getText().equals("1"))
					result++;
				else if (sel.get_select(ch, sub, q, 1).isSelected() == true
						&& sel.get_select(ch, sub, q, 1).getText().equals("1"))
					result++;
				else if (sel.get_select(ch, sub, q, 2).isSelected() == true
						&& sel.get_select(ch, sub, q, 2).getText().equals("1"))
					result++;
			}

			int result1 = JOptionPane.showConfirmDialog(null, "Score:" + (int) (((double) result / 3) * 100) + "/100",
					"result", JOptionPane.CLOSED_OPTION);
			if (result1 == JOptionPane.CLOSED_OPTION || result1 == JOptionPane.OK_OPTION) {
			bs_elem.set_now_panel(Quiz_Content.this);
				bs_elem.set_main_panel(init_panel);
				bs_elem.back();
				submit_btn.setVisible(false);
				this.remove(submit_btn);
			}

			result = 0;
		}
	}

	// set_init_panel(JPanel init): init_panel setter.
	public void set_init_panel(JPanel init) {
		this.init_panel = init;
	}

	// clear : empty panel and button group.
	public void clear() {
		sel = new Quiz_Select();
		super.removeAll();
		this.quiz1 = new ButtonGroup();
		this.quiz2 = new ButtonGroup();
		this.quiz2 = new ButtonGroup();

		super.add(clock);

	}

	//add getter to use submit btn in the Timer_set class. 
	public JButton getSubmit_btn() {
		return submit_btn;
	}
	
}