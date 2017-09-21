package GUIng_Content;
/*
 * Summary_Content class
 * 용도: Content_Panel class 상속받아서 summary content 생성
 * */
import javax.swing.*;

public class Summary_Content extends Content_Panel {
	
	private int main_ch = 0; //chapter number variable
	private int sub_ch = 0; //sub chapter number variable
	private JLabel summary; //label for summary contents

	public Summary_Content(int main_ch, int sub_ch) {
		this.main_ch = main_ch;
		this.sub_ch = sub_ch;
		var_init();
		summary_init(main_ch, sub_ch);
		add_to_panel();
	}

	public void var_init() {
		this.summary = new JLabel();
	}
	
	//summary_init(int main_ch, int sub_ch): get summary image for each chapter. and set summary label
	public void summary_init(int main_ch, int sub_ch) {
		summary.setBounds(10, 10, 710, 792);
		summary.setIcon(new ImageIcon(Lecture_Content.class.getResource(
				"/Summary_Content/" + String.valueOf(main_ch) +"-" +String.valueOf(sub_ch) +".png")));

	}

	public void add_to_panel() {
		super.add(summary);
	}
}
