package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class SimpleDisplay extends JFrame{
	
	private JButton[] buttons;
	private MyActionListener l = new MyActionListener();
	//private SubMenuBuilder smb = new SubMenuBuilder();   // create a SubMenuBuilder
	//private MenuDirector d = new MenuDirector(smb);        // create a MenuDirector


	public SimpleDisplay (String title) {
		super(title);
	}
	
	
	public void setButtons (JButton[] buttons) {
		this.buttons=buttons;
		for ( int i=0; i<this.buttons.length; i++ )
			this.buttons[i].addActionListener(this.l);
	}

	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}

	}
}