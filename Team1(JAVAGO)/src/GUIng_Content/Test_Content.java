package GUIng_Content;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import GUIng.GUI;
import GUIng_Etc.Base_Element;
import GUIng_Etc.String_set;
import GUIng_Select.Test_Select;

public class Test_Content extends Content_Panel {

	Base_Element bs_elem = new Base_Element();

	private JPanel panel1; //panel of the first page of test
	private JPanel panel2; //panel of the second page of test
	private JPanel init_panel; // init panel
	private JButton previous;	//previous btn to access previous page
	private JButton next;	//next btn to access next page
	private JButton submit; //submit btn to access next page

	private ButtonGroup test1 = new ButtonGroup(); // button groups for questions.
	private ButtonGroup test2 = new ButtonGroup();
	private ButtonGroup test3 = new ButtonGroup();
	private ButtonGroup test4 = new ButtonGroup();
	private ButtonGroup test5 = new ButtonGroup();

	private int result1, result2 = 0;	//point of the each page. after test, calculate the test score adding these two variables.
	private int ch = -1; //to take chapter, declare int ch

	Test_Select sel = new Test_Select();	//declare and create Test_Select class object to get the each question image.

	public Test_Content() {
		var_init();
		content_panel_init1();
		previous_init();
		add_to_panel();
	}

	// make content in panel
	public void var_init() {
		this.panel1 = new JPanel();
		this.panel2 = new JPanel();
		this.previous = new JButton();
		this.next = new JButton();
		this.submit = new JButton();

	}

	public void content_panel_init1() {
		super.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		super.setBackground(bs_elem.get_content_panel_Color());

	}

	// panel1_init: call questions and selects by ch and sub values, and add to panel of the first page.
	public void panel1_init(int ch) {
		this.panel1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.panel1.setBounds(10, 10, 730, 812);
		this.panel1.setBackground(bs_elem.get_content_panel_Color());
		this.panel1.setLayout(null);

		sel.get_question(ch, 0).setBounds(0, 0, 640, 100);
		sel.get_select(ch, 0, 0).setBounds(0, 100, 640, 50);
		sel.get_select(ch, 0, 1).setBounds(0, 150, 640, 50);
		sel.get_select(ch, 0, 2).setBounds(0, 200, 640, 50);

		test1.add(sel.get_select(ch, 0, 0));
		test1.add(sel.get_select(ch, 0, 1));
		test1.add(sel.get_select(ch, 0, 2));

		this.panel1.add(sel.get_question(ch, 0));
		this.panel1.add(sel.get_select(ch, 0, 0));
		this.panel1.add(sel.get_select(ch, 0, 1));
		this.panel1.add(sel.get_select(ch, 0, 2));

		sel.get_question(ch, 1).setBounds(0, 250, 640, 100);
		sel.get_select(ch, 1, 0).setBounds(0, 350, 640, 50);
		sel.get_select(ch, 1, 1).setBounds(0, 400, 640, 50);
		sel.get_select(ch, 1, 2).setBounds(0, 450, 640, 50);

		test2.add(sel.get_select(ch, 1, 0));
		test2.add(sel.get_select(ch, 1, 1));
		test2.add(sel.get_select(ch, 1, 2));

		this.panel1.add(sel.get_question(ch, 1));
		this.panel1.add(sel.get_select(ch, 1, 0));
		this.panel1.add(sel.get_select(ch, 1, 1));
		this.panel1.add(sel.get_select(ch, 1, 2));

		sel.get_question(ch, 2).setBounds(0, 500, 640, 100);
		sel.get_select(ch, 2, 0).setBounds(0, 600, 640, 50);
		sel.get_select(ch, 2, 1).setBounds(0, 650, 640, 50);
		sel.get_select(ch, 2, 2).setBounds(0, 700, 640, 50);

		test3.add(sel.get_select(ch, 2, 0));
		test3.add(sel.get_select(ch, 2, 1));
		test3.add(sel.get_select(ch, 2, 2));

		this.panel1.add(sel.get_question(ch, 2));
		this.panel1.add(sel.get_select(ch, 2, 0));
		this.panel1.add(sel.get_select(ch, 2, 1));
		this.panel1.add(sel.get_select(ch, 2, 2));

		this.panel1.setVisible(true);

	}

	// panel2_init: call questions and selects by ch and sub values, and add to panel of the second page.
	public void panel2_init(int ch) {

		this.panel2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.panel2.setBounds(10, 10, 730, 812);
		this.panel2.setBackground(bs_elem.get_content_panel_Color());
		this.panel2.setLayout(null);

		sel.get_question(ch, 3).setBounds(0, 0, 640, 100);
		sel.get_select(ch, 3, 0).setBounds(0, 100, 640, 50);
		sel.get_select(ch, 3, 1).setBounds(0, 150, 640, 50);
		sel.get_select(ch, 3, 2).setBounds(0, 200, 640, 50);

		test4.add(sel.get_select(ch, 3, 0));
		test4.add(sel.get_select(ch, 3, 1));
		test4.add(sel.get_select(ch, 3, 2));

		this.panel2.add(sel.get_question(ch, 3));
		this.panel2.add(sel.get_select(ch, 3, 0));
		this.panel2.add(sel.get_select(ch, 3, 1));
		this.panel2.add(sel.get_select(ch, 3, 2));
		if(ch==1){
			sel.get_question(ch, 4).setBounds(0, 300,720, 150);
			sel.get_select(ch, 4, 0).setBounds(0, 450, 720, 50);
			sel.get_select(ch, 4, 1).setBounds(0, 500, 720, 50);
			sel.get_select(ch, 4, 2).setBounds(0, 550, 720, 50);
		}
		else{
			sel.get_question(ch, 4).setBounds(0, 300,640, 150);
			sel.get_select(ch, 4, 0).setBounds(0, 450, 640, 50);
			sel.get_select(ch, 4, 1).setBounds(0, 500, 640, 50);
			sel.get_select(ch, 4, 2).setBounds(0, 550, 640, 50);
		}
	

		test5.add(sel.get_select(ch, 4, 0));
		test5.add(sel.get_select(ch, 4, 1));
		test5.add(sel.get_select(ch, 4, 2));

		this.panel2.add(sel.get_question(ch, 4));
		this.panel2.add(sel.get_select(ch, 4, 0));
		this.panel2.add(sel.get_select(ch, 4, 1));
		this.panel2.add(sel.get_select(ch, 4, 2));

		this.previous_init();
		this.panel2.add(this.previous);
		this.panel2.add(this.submit);
		this.panel2.setVisible(false);

	}

	// previous_init : create previous button and add functions to access to previous page. 
	public void previous_init() {
		this.previous = new JButton();
		this.previous.setFocusPainted(false);
		this.previous.setBorderPainted(false);
		this.previous.setContentAreaFilled(false);
		this.previous.setIcon(new ImageIcon(GUI.class.getResource("/Test/pre_icon.png")));

		this.previous.setBounds(0, 750, 50, 50);
		this.previous.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel2.setVisible(false);
				panel1.setVisible(true);

			}
		});
	}

	// next_init : create next button and add functions to access to next page. 
	public void next_init(int ch) {
		this.ch = ch;
		this.next = new JButton();
		this.next.setFocusPainted(false);
		this.next.setBorderPainted(false);
		this.next.setContentAreaFilled(false);
		this.next.setIcon(new ImageIcon(GUI.class.getResource("/Test/next_icon.png")));
		this.next.setBounds(680, 750, 50, 50);
		this.panel1.add(this.next);

		this.next.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (test1.isSelected(null) || test2.isSelected(null) || test3.isSelected(null)) {	//checks every questions to restrain from accessing to next page if there is left questions to solve.
					JOptionPane.showMessageDialog(null, "There are questions that you didn't solved yet.");

				} else {
					for (int q = 0; q < 3; q++) {	//checks if chosen question is the correct answer, and if it is correct, adding the point.
						if (sel.get_select(Test_Content.this.ch, q, 0).isSelected() == true
								&& sel.get_select(Test_Content.this.ch, q, 0).getText().equals("1"))
							result1++;
						else if (sel.get_select(Test_Content.this.ch, q, 1).isSelected() == true
								&& sel.get_select(Test_Content.this.ch, q, 1).getText().equals("1"))
							result1++;
						else if (sel.get_select(Test_Content.this.ch, q, 2).isSelected() == true
								&& sel.get_select(Test_Content.this.ch, q, 2).getText().equals("1"))
							result1++;
					}
					String_set.set_test(Test_Content.this.ch, result1);

					panel1.setVisible(false);
					panel2.setVisible(true);
				}
				result1 = 0;
			}
		});
	}

	public void set_init_panel(JPanel init) {
		this.init_panel = init;
	}

	// submit_init : create initial submit button and add functions
	public void submit_init(int ch) {
		this.ch = ch;
		this.submit = new JButton();
		this.submit.setFocusPainted(false);
		this.submit.setBorderPainted(false);
		this.submit.setContentAreaFilled(false);
		this.submit.setIcon(new ImageIcon(GUI.class.getResource("/Test/submit_icon.png")));
		this.submit.setBounds(293, 700, 144, 109);
		this.panel2.add(this.submit);

		this.submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doSubmit();
			}
		});
	}

	// do_Submit(): work when submit button clicked. score the test.
	public void doSubmit() {
		if (test4.isSelected(null) || test5.isSelected(null)){
			JOptionPane.showMessageDialog(null, "There are questions that you didn't solved yet.");
			bs_elem.set_now_panel(Test_Content.this);
			bs_elem.set_main_panel(init_panel);
			bs_elem.back();
		}
			else {
			for (int q = 3; q < 5; q++) {
				if (sel.get_select(Test_Content.this.ch, q, 0).isSelected() == true
						&& sel.get_select(Test_Content.this.ch, q, 0).getText().equals("1"))
					result2++;
				else if (sel.get_select(Test_Content.this.ch, q, 1).isSelected() == true
						&& sel.get_select(Test_Content.this.ch, q, 1).getText().equals("1"))
					result2++;
				else if (sel.get_select(Test_Content.this.ch, q, 2).isSelected() == true
						&& sel.get_select(Test_Content.this.ch, q, 2).getText().equals("1"))
					result2++;
			}
			String_set.set_test(Test_Content.this.ch, result2 + String_set.get_test(Test_Content.this.ch));

			int result1 = JOptionPane.showConfirmDialog(null,
					"Score:" + (int) (((double) (String_set.get_test(Test_Content.this.ch)) / 5) * 100) + "/100",
					"Result", JOptionPane.CLOSED_OPTION);

			if (result1 == JOptionPane.CLOSED_OPTION || result1 == JOptionPane.OK_OPTION) {
				submit.setVisible(false);
				this.remove(submit);
				bs_elem.set_now_panel(Test_Content.this);
				bs_elem.set_main_panel(init_panel);
				bs_elem.back();
			}
			result2 = 0;
		}
	}

	public void add_to_panel() {
		this.panel2.add(this.previous);
		super.add(panel1);
		super.add(panel2);
	}

	// clear : clear panel and button group.
	public void clear() {	

		sel = new Test_Select();

		this.panel1.removeAll();
		this.panel2.removeAll();

		this.test1 = new ButtonGroup();
		this.test2 = new ButtonGroup();
		this.test3 = new ButtonGroup();
		this.test4 = new ButtonGroup();
		this.test5 = new ButtonGroup();
	}

	//add getter to use submit btn in the Timer_set class. 
	public JButton getSubmit() {
		return submit;
	}

}