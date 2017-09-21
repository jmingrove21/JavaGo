package GUIng_Init;

/* Test_Init_Panel class
 * USage : create initial page when by clicking test button
 * 
 * */
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import GUIng.GUI;
import GUIng_Content.Content_Panel;
import GUIng_Content.Test_Content;

public class Test_Init_Panel extends Panel_Code {
	private JPanel init_panel; // test initial displaying panel.
	private JLabel test_title; // test title label
	private JLabel text; // test text contents
	private JButton start_btn; // test initial _ start button
	private int main_ch = -1; // chapter 'n' value

	Content_Panel t = new Test_Content();

	public Test_Init_Panel(JPanel main_panel) {

		var_init(main_panel);
		panel_init();
		test_title_init();
		text_init();
		start_init();
		((Test_Content) t).set_init_panel(init_panel);
		this.add_panel();
	}

	public void var_init(JPanel main_panel) {
		super.main_panel = main_panel;
		this.init_panel = new JPanel();
		this.test_title = new JLabel();
		this.text = new JLabel();
		this.start_btn = new JButton();

		bs_elem.set_now_panel(panel_code);
		bs_elem.set_main_panel(main_panel);

	}

	// panel_init(): setting method for init_panel 
	public void panel_init() {
		this.init_panel.setBounds(0, 133, 750, 832);
		this.init_panel.setBackground(bs_elem.get_Color());
		this.init_panel.setVisible(true);
		this.init_panel.setLayout(null);
	}

	// test_title_init(): setting method for test_title 
	public void test_title_init() {
		this.test_title.setBounds(300, 67, 150, 150);
		this.test_title.setPreferredSize(new Dimension(12, 12));
		this.test_title.setMinimumSize(new Dimension(1, 12));
		this.test_title.setInheritsPopupMenu(false);
		this.test_title.setIcon(new ImageIcon(GUI.class.getResource("/Test/test_icon.png")));
	}

	// text_init(): setting method for text
	public void text_init() {
		this.text.setBounds(50, 247, 650, 400);
		this.text.setPreferredSize(new Dimension(12, 12));
		this.text.setMinimumSize(new Dimension(1, 12));
		this.text.setInheritsPopupMenu(false);
		this.text.setIcon(new ImageIcon(GUI.class.getResource("/Test/text_icon.png")));
	}

	// start_init(): start_btn: setting method, action when button selected. 
	public void start_init() {
		this.start_btn.setIcon(new ImageIcon(GUI.class.getResource("/Test/start_icon.png")));
		this.start_btn.setFocusPainted(false);
		this.start_btn.setContentAreaFilled(false);
		this.start_btn.setBorderPainted(false);
		this.start_btn.setBounds(303, 667, 144, 110);
		this.start_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				init_panel.setVisible(false);
				((Test_Content) t).clear();

				((Test_Content) t).set_init_panel(init_panel);
				((Test_Content) t).panel1_init(main_ch);
				((Test_Content) t).next_init(main_ch);

				((Test_Content) t).panel2_init(main_ch);
				((Test_Content) t).submit_init(main_ch);
				t.setVisible(true);

				bs_elem.get_ts().setTestcontent((Test_Content) t);
				bs_elem.get_ts().setTlimit(120);
				bs_elem.get_ts().getTt().setVisible(true);
				bs_elem.ti = new Thread(bs_elem.get_ts());
				bs_elem.ti.start();
			}
		});
	}

	// add_panel(): setting method for init_panel, method for adding super class panel_code 
	@Override
	public void add_panel() {
		init_panel.add(this.test_title);
		init_panel.add(this.text);
		init_panel.add(this.start_btn);
		super.panel_code.add(this.init_panel);
		super.panel_code.add(t);
	}

	// set_init_state(): initial display visible true, content visible false
	@Override
	public void set_init_state() {
		// TODO Auto-generated method stub
		t.setVisible(false);
		init_panel.setVisible(true);
	}

	// get_start_btn(): start_btn return
	public JButton get_start_btn() {
		return this.start_btn;
	}

	// set_ch(int main_ch): main_ch setter
	public void set_ch(int main_ch) {
		this.main_ch = main_ch - 1;
	}
}
