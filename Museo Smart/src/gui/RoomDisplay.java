package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class RoomDisplay extends JFrame{
	
	private JButton[] buttons;
	MyActionListener l = new MyActionListener();
	//SubMenuBuilder smb = new SubMenuBuilder();   // create a SubMenuBuilder
	//MenuDirector d = new MenuDirector(smb);        // create a MenuDirector


	public RoomDisplay (String title) {
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