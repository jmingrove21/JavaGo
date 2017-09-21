package GUIng_Init;

/* Lecture_Init_Panel class
 * Usage : implement panel shown by clicking lecture button
 * extends Panel_Code
 * */


import javax.swing.*;

public class Lecture_Init_Panel extends Panel_Code {
	private int main_ch = -1; //chapter variable
	private int sub_ch = -1; //sub chapter variable
	
	
	public Lecture_Init_Panel(JPanel main_panel) {
		var_init(main_panel);
	}

	@Override
	public void var_init(JPanel main_panel) {
		super.main_panel = main_panel;
		bs_elem.set_now_panel(panel_code);
		bs_elem.set_main_panel(main_panel);
		
	}

	@Override
	public JPanel get_panel_code() {
		return super.get_panel_code();
	}

	
//set_ch(int main_ch, int sub_ch): main_ch, sub_ch setter.
	public void set_ch(int main_ch, int sub_ch) {
		this.main_ch = main_ch;
		this.sub_ch = sub_ch;
	}
}
