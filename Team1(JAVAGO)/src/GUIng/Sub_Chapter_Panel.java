/* Sub_Lecture_Panel
 * Usage : frame contains buttons and labels in sub chapter(lecture, summary, etc)
 *         buttons in sub chapter will be used in other classes 
 *         so they implement JButton method.
 * */


package GUIng;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GUIng_Etc.String_set;

public class Sub_Chapter_Panel extends JPanel{
	
	private JButton lecture; // declare JButton that start the lecture
	private JButton summary; // declare JButton that start the summary
	private JButton quiz; // declare JButton that start the quiz
	private JLabel label; // declare label JLabel
	private JLabel lecture_name; // declare lecture name JLabel
	private int ch_num; // which make that can take the chapter number
	private int sub_ch_num; // which make that can take the chapter number
	
	public Sub_Chapter_Panel(int ch_num, int sub_ch_num) {
		this.ch_num = ch_num;
		this.sub_ch_num = sub_ch_num;
		
		var_init();
		panel_init();
		lec_init();
		sum_init();
		quiz_init();
		label_init();
		lecture_name_init();	
		add_to_panel();
		
	}
	// make constructor Sub_Chapter_Panel with  parameter (chapter number and sub chapter number)
	public void var_init() {
		
		this.label = new JLabel();
		this.lecture = new JButton();
		this.summary = new JButton();
		this.quiz = new JButton();
	}
	public void panel_init() {
		this.setSize(230, 199);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
	}
	// set the panel that contain contents
	public void lec_init() {
		this.lecture.setIcon(new ImageIcon(GUI.class.getResource("/Sub_Lecture/lec_icon.png")));
		this.lecture.setFocusPainted(false);
		this.lecture.setContentAreaFilled(false);
		this.lecture.setBorderPainted(false);
		this.lecture.setBounds(0, 116, 70, 70);
	
	}
	// insert the icon to lecture set the lecture
	public void sum_init() {
		this.summary.setIcon(new ImageIcon(GUI.class.getResource("/Sub_Lecture/sum_icon.png")));
		this.summary.setFocusPainted(false);
		this.summary.setContentAreaFilled(false);
		this.summary.setBorderPainted(false);
		this.summary.setBounds(80, 116, 70, 70);
	}
	// insert the icon to summary set the summary
	public void quiz_init() {
		this.quiz.setIcon(new ImageIcon(GUI.class.getResource("/Sub_Lecture/quiz_icon.png")));
		this.quiz.setFocusPainted(false);
		this.quiz.setContentAreaFilled(false);
		this.quiz.setBorderPainted(false);
		this.quiz.setBounds(160, 113, 70, 70);
	}
// insert the icon to quiz set the quiz
	public void label_init() {
		this.label.setIcon(new ImageIcon(GUI.class.getResource("/Sub_Lecture/sub_icon.png")));
		this.label.setBounds(87, 10, 57, 57);
	}
	//isert the icon to label and set the label
	public void lecture_name_init(){
		this.lecture_name=new JLabel(this.sub_ch_num+". "+String_set.sub_ch_name[this.ch_num-1][this.sub_ch_num-1]);
		this.lecture_name.setFont(new Font("Century Gothic", Font.BOLD, 17));
		this.lecture_name.setHorizontalAlignment(SwingConstants.CENTER);
		this.lecture_name.setBounds(12,77,205,29);
	}
	// set the lecture_name JLabel with chapter and sub chapter number
	public void add_to_panel() {
		this.add(this.lecture);
		this.add(this.summary);
		this.add(this.quiz);
		this.add(this.label);
		this.add(this.lecture_name);
	}
	//add panel
	public JButton get_lecture_btn(){
		return this.lecture;
	}
	public JButton get_summary_btn(){
		return this.summary;
	}
	public JButton get_quiz_btn(){
		return this.quiz;
	}
// make get_lecture_btnm, get_summary_btn, get_quiz_btn getter
	


}
