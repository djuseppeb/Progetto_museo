package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class HomeMenu extends JFrame {
	
	private JButton[] buttons;
	MyActionListener l = new MyActionListener();
	SubMenuBuilder smb = new SubMenuBuilder();   // create a SubMenuBuilder
	MenuDirector d = new MenuDirector(smb);        // create a MenuDirector

	public HomeMenu (String title) {
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
			
			JButton jb = (JButton)e.getSource();
			if (jb.getText().equals("Stanze")) {
				d.make("Stanze", "Stanza 1", "Stanza 2", "Stanza 3", "Stanza 4");
				smb.getProduct();
			}
			else if (jb.getText().equals("Opere")) {
				d.make("Opere", "Visualizza opere", "Aggiungi opera", "Modifica opera");
				smb.getProduct();
			}
			else
				System.exit(0);
		
	}
	
}
	
}
