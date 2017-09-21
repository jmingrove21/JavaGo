package GUIng_Content;
/*
 *  Lecture_Content class
 *  make each lecture panels of chapter, sub chapter. extends ontent_Panel
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Lecture_Content extends Content_Panel implements ActionListener {
	CardLayout layout;

	private JPanel south; // bottom buttons' panel
	private JPanel center; // lecture panel on center

	private JButton first; // button to go first page
	private JButton previous; // button to go previous page
	private JButton next; // button to go next
	private JButton last; // button to go last page

	private JLabel lec1; // cardlayout first label
	private JLabel lec2; // cardlayout second label
	private JLabel lec3; // cardlayout third label
	private int main_ch = -1; // chapter variable
	private int sub_ch = -1; // sub chapter variable

	public Lecture_Content(int main_ch, int sub_ch) {
		this.main_ch = main_ch;
		this.sub_ch = sub_ch;
		var_init();
		content_panel_init(this.main_ch, this.sub_ch);
		button_init();
		add_panel();
	}

	public void var_init() {
		this.south = new JPanel();
		this.center = new JPanel();
		this.layout = new CardLayout();
		this.first = new JButton();
		this.previous = new JButton();
		this.next = new JButton();
		this.last = new JButton();
		this.lec1 = new JLabel();
		this.lec2 = new JLabel();
		this.lec3 = new JLabel();
	}

	// content_panel_init(int main_ch, int sub_ch): compose panel with chapter with sub chapter values.
	public void content_panel_init(int main_ch, int sub_ch) {
		this.main_ch = main_ch;
		this.sub_ch = sub_ch;
		
		super.removeAll();
		this.south.removeAll();
		this.center.removeAll();
		
		layout.removeLayoutComponent(lec1);
		layout.removeLayoutComponent(lec2);
		layout.removeLayoutComponent(lec3);
		layout.removeLayoutComponent(center);

		lec1 = new JLabel();
		lec2 = new JLabel();
		lec3 = new JLabel();

		this.south.setBounds(0, 729, 730, 83);
		this.center.setBounds(0, 0, 730, 719);

		center.setLayout(layout);

		lec1.setBounds(10, 10, 400, 400);
		lec2.setBounds(10, 10, 400, 400);
		lec3.setBounds(10, 10, 400, 400);
		
		lec1.setIcon(new ImageIcon(Lecture_Content.class.getResource(
				"/Lecture_Content/" + "lec" + String.valueOf(main_ch) + String.valueOf(sub_ch) + "1.png")));
		lec2.setIcon(new ImageIcon(Lecture_Content.class.getResource(
				"/Lecture_Content/" + "lec" + String.valueOf(main_ch) + String.valueOf(sub_ch) + "2.png")));
		lec3.setIcon(new ImageIcon(Lecture_Content.class.getResource(
				"/Lecture_Content/" + "lec" + String.valueOf(main_ch) + String.valueOf(sub_ch) + "3.png")));
	}

	public void add_panel() {
		center.add(lec1, "1");
		center.add(lec2, "2");
		center.add(lec3, "3");

		south.add(first);
		south.add(previous);
		south.add(next);
		south.add(last);

		super.add(center, "Center");
		super.add(south, "North");
	}

	// composing buttons on bottom of panel
	public void button_init() {
		first.setSize(100, 67);
		last.setSize(100, 67);
		previous.setSize(100, 67);
		next.setSize(100, 67);

		this.first.setIcon(new ImageIcon(Lecture_Content.class.getResource("/Lecture_Content/first_icon.png")));
		this.last.setIcon(new ImageIcon(Lecture_Content.class.getResource("/Lecture_Content/last_icon.png")));
		this.previous.setIcon(new ImageIcon(Lecture_Content.class.getResource("/Lecture_Content/pre_icon.png")));
		this.next.setIcon(new ImageIcon(Lecture_Content.class.getResource("/Lecture_Content/next_icon.png")));

		this.first.setFocusPainted(false);
		this.first.setContentAreaFilled(false);
		this.first.setBorderPainted(false);

		this.last.setFocusPainted(false);
		this.last.setContentAreaFilled(false);
		this.last.setBorderPainted(false);

		this.previous.setFocusPainted(false);
		this.previous.setContentAreaFilled(false);
		this.previous.setBorderPainted(false);

		this.next.setFocusPainted(false);
		this.next.setContentAreaFilled(false);
		this.next.setBorderPainted(false);

		first.addActionListener(this);
		last.addActionListener(this);
		previous.addActionListener(this);
		next.addActionListener(this);

	}

	@Override // first, previous, next, last button listener
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == first) {
			layout.first(center);
		} else if (e.getSource() == previous) {
			layout.previous(center);
		} else if (e.getSource() == next) {
			layout.next(center);
		} else if (e.getSource() == last) {
			layout.last(center);
		}
	}
}