package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import gui.HomeMenu.MyActionListener;


public class SubMenu extends JFrame{
	
	private JButton[] buttons;
	MyActionListener l = new MyActionListener();
	SubMenuBuilder smb = new SubMenuBuilder();   // create a SubMenuBuilder
	MenuDirector d = new MenuDirector(smb);        // create a MenuDirector


	public SubMenu (String title) {
		super(title);
	}
	
	
	public JButton[] getButtons () {
		return this.buttons;
	}
	
	public void setButtons (JButton[] buttons) {
		this.buttons=buttons;
		for ( int i=0; i<this.buttons.length; i++ )
			this.buttons[i].addActionListener(this.l);
	}

	
	class MyActionListener implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton)e.getSource();
			
			if (jb.getText().equals("Stanza 1")) {				
			}
			else if (jb.getText().equals("Stanza 2")) {
			}
			else if (jb.getText().equals("Stanza 3")) {
			}
			else if (jb.getText().equals("Stanza 4")) {
			}
			else if (jb.getText().equals("Visualizza opere")) {
			}
			else if (jb.getText().equals("Aggiungi opera")) {
			}
			else if (jb.getText().equals("Modifica opera")) {
			}
			else
				dispose();
		}
	}
}