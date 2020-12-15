package gui;

import javax.swing.JButton;
import javax.swing.JFrame;


public class HomeMenu extends JFrame{
	
	private JButton[] buttons;
	

	public HomeMenu (String title) {
		super(title);
	}
	
	
	public JButton[] getButtons () {
		return this.buttons;
	}
	
	public void setButtons (JButton[] buttons) {
		this.buttons=buttons;
	}

}
