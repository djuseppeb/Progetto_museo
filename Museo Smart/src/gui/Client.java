package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class Client implements ActionListener{
	
	static String clickedButton = "";  // contains the text of the clicked button

	public static void main(String[] args) throws InterruptedException {
		Client c = new Client();
		HomeMenuBuilder hmb = new HomeMenuBuilder();   // create a HomeMenuBuilder
		MenuDirector d = new MenuDirector(hmb);        // create a MenuDirector
		
		// get home GUI (menu)
		d.make("Home", "Stanze", "Opere");
		HomeMenu homeGUI = hmb.getProduct();
		JButton[] homeGUIButtons = homeGUI.getButtons();
		for ( int i=0; i<homeGUIButtons.length; i++ )
			homeGUIButtons[i].addActionListener(c);
		homeGUI.setVisible(true);
		
		SubMenuBuilder smb = new SubMenuBuilder();    // create a SubMenuBuilder
		d.changeBuilder(smb);          // give a SubMenuBuilder to MenuDirector
		
		// get room list GUI (submenu)
		d.make("Stanze", "Stanza 1", "Stanza 2", "Stanza 3", "Stanza 4");
		SubMenu roomListGUI = smb.getProduct();
		JButton[] roomListGUIButtons = roomListGUI.getButtons();
		for ( int i=0; i<roomListGUIButtons.length; i++ )
			roomListGUIButtons[i].addActionListener(c);
		
		// get artwork GUI (submenu)
		d.make("Opere", "Visualizza opera", "Aggiungi opera", "Modifica opera");
		SubMenu artworkGUI = smb.getProduct();
		JButton[] artworkGUIButtons = artworkGUI.getButtons();
		for ( int i=0; i<artworkGUIButtons.length; i++ )
			artworkGUIButtons[i].addActionListener(c);

		
		//DisplayBuilder displayBuilder = new DisplayBuilder();     // create a DisplayBuilder
		
		while (true) {
			if ( clickedButton.equals("Stanze") )
				roomListGUI.setVisible(true);
			
			else if ( clickedButton.equals("Opere") )
				artworkGUI.setVisible(true);
			
			
			// get room GUI
			else if ( clickedButton.equals("Stanza 1") ) {
				System.out.println("Hai cliccato Stanza 1");
		
				//d.changeBuilder(displayBuilder);   // give a DisplayBuilder to the Director
				
				//ArrayList <Room> rooms= getRoomList();
				
				
				
					/*	
				d.makeRoomGUI(1, "Temperatura: 20\n N.persone: 10");
				Display roomGUI = displayBuilder.getProduct();
				JButton[] roomGUIButtons = roomGUI.getButtons();
				for ( int i=0; i<roomGUIButtons.length; i++ )
					roomGUIButtons[i].addActionListener(c);*/
			}
				
				
			
			// get artwork list GUI
				
			// get artwork GUI
			
			
				
			// back to home
			else if ( clickedButton.equals("HOME") ) {
				roomListGUI.dispose();
				artworkGUI.dispose();
				//GUI2.dispose()
				//GUI3.dispose()
				//GUI4.dispose()
			}
			
			// Quit
			else if ( clickedButton.equals("CHIUDI") )
				System.exit(0);
			
			
			clickedButton = "";
			Thread.sleep(300);
		}
}


	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jb = (JButton)e.getSource();
		clickedButton = jb.getText();
	}
	
}
