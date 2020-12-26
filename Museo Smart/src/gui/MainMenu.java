package gui;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;


import javax.swing.JButton;
import javax.swing.JFrame;

import database.Manager;
import database.Opera;


public class MainMenu extends JFrame {
	
	
	private JButton[] buttons;
	private MyActionListener l = new MyActionListener();
	private SubMenuBuilder smb = new SubMenuBuilder();   // create a SubMenuBuilder
	private MenuDirector md = new MenuDirector(smb);        // create a MenuDirector
	private EnhancedDisplayBuilder edb = new EnhancedDisplayBuilder(); // create an EnhancedDisplayBuilder
	private DisplayDirector dd = new DisplayDirector(edb);       // create a DisplayDirector

	public MainMenu (String title) {
		super(title);
	}
	
	
	public void setButtons (JButton[] buttons) {
		this.buttons=buttons;
		for ( int i=0; i<this.buttons.length; i++ )
			this.buttons[i].addActionListener(this.l);
	}

	public JButton[] getButtons() {
		return this.buttons;
	}
	

	
	class MyActionListener implements ActionListener {

	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JButton jb = (JButton)e.getSource();
			if (jb.getText().equals("Stanze")) {
				md.make("Stanze", "Stanza 1", "Stanza 2", "Stanza 3", "Stanza 4");
				smb.getProduct();
			}
			else if (jb.getText().equals("Opere")) {
				List <Opera> operaList;     // operaList is a list of Opera objects
				operaList = Manager.getArtList();
				ArrayList<String> artworks = new ArrayList<>();    // artworks is a list of String
				for (Opera o : operaList) {
					artworks.add(Manager.getStringOpera(o));
					artworks.add("\n");
				}
				dd.make("Opere", artworks, "Visualizza");
				edb.getProduct();
			}
			else
				System.exit(0);
		}
	
	}


	
}

