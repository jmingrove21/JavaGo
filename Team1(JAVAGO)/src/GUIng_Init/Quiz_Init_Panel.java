package GUIng_Init;
/* Quiz_init_panel class
 * Usage : implementing quiz panel shown when clicked quiz button
 * 
 * */
import GUIng.GUI;
import GUIng_Content.Content_Panel;
import GUIng_Content.Quiz_Content;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class Quiz_Init_Panel extends Panel_Code {

	private JPanel init_panel; // quiz initial panel
	private JLabel text; // quiz text contents
	private JButton start_btn; // quiz initial start button
	private JLabel quiz_title; // quiz title label
	private int main_ch = -1; // chapter number variable
	private int sub_ch = -1; // sub chapter number variable

	Content_Panel q = new Quiz_Content(main_ch, sub_ch);

	public Quiz_Init_Panel(JPanel main_panel) {

		var_init(main_panel);
		text_init();
		start_init();
		quiz_title_init();
		content_panel_init();
		this.add_panel();

	}

	public void var_init(JPanel main_panel) {
		super.main_panel = main_panel;
		this.init_panel = new JPanel();
		this.quiz_title = new JLabel();
		this.start_btn = new JButton();
		this.text = new JLabel();

		bs_elem.set_now_panel(super.panel_code);
		bs_elem.set_main_panel(super.main_panel);

	}

	// quiz_title_init(): set quiz_title
	public void quiz_title_init() {
		this.quiz_title.setBounds(245, 20, 260, 100);
		this.quiz_title.setIcon(new ImageIcon(GUI.class.getResource("/Quiz/quiz_icon.png")));

	}

	// text_init(): set text
	public void text_init() {
		this.text.setBounds(125, 130, 500, 611);
		this.text.setIcon(new ImageIcon(GUI.class.getResource("/Quiz/text_icon.png")));

	}

	// content_panel_init(): set content_panel
	public void content_panel_init() {
		this.init_panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		this.init_panel.setBounds(0, 133, 750, 832);
		this.init_panel.setBackground(bs_elem.get_Color());
		this.init_panel.setLayout(null);
		this.init_panel.setVisible(true);
	}
	// start_init(): set start_btn, and action of clicking button
	public void start_init() {
		this.start_btn.setFocusPainted(false);
		this.start_btn.setBorderPainted(false);
		this.start_btn.setContentAreaFilled(false);
		this.start_btn.setIcon(new ImageIcon(GUI.class.getResource("/Quiz/start_icon.png")));
		this.start_btn.setBounds(300, 740, 144, 110);

		this.start_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				init_panel.setVisible(false);
				((Quiz_Content) q).clear();
				((Quiz_Content) q).set_init_panel(init_panel);
				((Quiz_Content) q).quiz_q_panel(main_ch, sub_ch);
				((Quiz_Content) q).submit_click(main_ch, sub_ch);

				bs_elem.get_ts().setQuizContent((Quiz_Content) q);
				bs_elem.get_ts().setTlimit(60);
				bs_elem.get_ts().getTt().setVisible(true);
				bs_elem.ti = new Thread(bs_elem.get_ts());
				bs_elem.ti.start();
				q.setVisible(true);
			}
		});
	}
	//set_ch(int main_ch, int sub_ch): main_ch, sub_ch setter
	public void set_ch(int main_ch, int sub_ch) {
		this.main_ch = main_ch - 1;
		this.sub_ch = sub_ch;
	}

	// set_init_state(): initial panel visible true, content visible false
	@Override
	public void set_init_state() {
		q.setVisible(false);
		init_panel.setVisible(true);
	}

	// add_panel(): add to init_panel and super class panel_code
	@Override
	public void add_panel() {
		// TODO Auto-generated method stub
		this.init_panel.add(this.start_btn);
		this.init_panel.add(this.text);
		this.init_panel.add(this.quiz_title);
		super.panel_code.add(this.q);
		super.panel_code.add(this.init_panel);
	}

}