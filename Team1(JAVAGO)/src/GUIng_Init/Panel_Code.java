package GUIng_Init;
/*
 * Panel_Code class
 * panel size of 750*1000 changed by lecture, summary, quiz, test, game buttons
 * */
import javax.swing.*;

import GUIng_Etc.Base_Element;

public abstract class Panel_Code {
	public Base_Element bs_elem = new Base_Element();
	public JPanel panel_code = bs_elem.get_panel_code(); //changeable panel sized 750*1000
	public JPanel main_panel; //initial page
	
	
	public abstract void var_init(JPanel main_panel);
	
	public void add_panel() {
	}
	
	public void set_init_state() {
	}
	
	//get_panel_code(): panel_code return.
	public JPanel get_panel_code() {
		return panel_code;
	}

	//get_bs_element(): Base_element return
	public Base_Element get_bs_element() {
		return this.bs_elem;
	}
}
