package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.Manager;
import database.Room;
import gui.HomeMenu.MyActionListener;


public class SubMenu extends JFrame{
	
	private JButton[] buttons;
	MyActionListener l = new MyActionListener();
	RoomDisplayBuilder rmb = new RoomDisplayBuilder();   // create a RoomDisplayBuilder
	DisplayDirector d = new DisplayDirector(rmb);        // create a DisplayDirector


	public SubMenu (String title) {
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
			
			if (jb.getText().equals("Stanza 1")) {
				List<Room> rooms = Manager.getRoomList();
				/*
				String info = "Informazioni Stanza 1 : "+"\n"+
				"Temperatura : "+rooms.get(0).getTemp()+"\n"+"N.Persone : "+rooms.get(0).getTemp()+"\n"
						+"Distanza Media : "+Get_DistanzaMedia()[i]+"\n"+"Impianto Termico : "
						+Get_ImpiantoTermico()[i]+"\n"+"Distanziamento : "+Get_Distanziamento()[i]);
				*/
				String info = "Informazioni Stanza 1 : "+"\n"+
								"Temperatura : "+rooms.get(0).getTemp()+"\n"+
								"N.Persone : "+rooms.get(0).getPeople();
				d.make("Stanza 1", info);
				rmb.getProduct();
				
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