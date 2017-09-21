package GUIng_Content;
import javax.swing.JPanel;

public class Content_Panel extends JPanel{
	private JPanel content_panel; //every sub content class extends this class.
	public Content_Panel(){
		content_panel_init();
	}
	public void content_panel_init(){ //set the size and location of the panel.
		this.setBounds(10,143,730,812);
		this.setLayout(null);
	}	
}
