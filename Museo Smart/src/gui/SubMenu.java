package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import database.Manager;
import database.Opera;
import database.Room;


public class SubMenu extends JFrame{
	
	private JButton[] buttons;
	private MyActionListener l = new MyActionListener();
	private SimpleDisplayBuilder sdb = new SimpleDisplayBuilder();   // create a SipleDisplayBuilder
	private DisplayDirector dd = new DisplayDirector(sdb);        // create a DisplayDirector


	public SubMenu (String title) {
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

		
		public void actionPerformed(ActionEvent e) {
            JButton jb = (JButton)e.getSource();
            int i;
            ArrayList<String> roomInfo = new ArrayList<>();
           
            if (jb.getText().equals("Stanza 1")) {
                i=1;
                List<Room> rooms = Manager.getRoomList();
                roomInfo.add(Manager.getRoomString(rooms.get(i-1)));
                roomInfo.add("\n\n----------------------------------\nOpere Disponibili:");
                List<Opera> artworks = Manager.getArtList();
                roomInfo.add(Manager.getAvilableOperaString((ArrayList<Opera>) artworks, i));
                dd.make("Stanza "+i, roomInfo);
                sdb.getProduct();
               
            }
            else if (jb.getText().equals("Stanza 2")) {
                i=2;
                List<Room> rooms = Manager.getRoomList();
                roomInfo.add(Manager.getRoomString(rooms.get(i-1)));
                roomInfo.add("\n\n----------------------------------\nOpere Disponibili:");
                List<Opera> artworks = Manager.getArtList();
                roomInfo.add(Manager.getAvilableOperaString((ArrayList<Opera>) artworks, i));
                dd.make("Stanza "+i, roomInfo);
                sdb.getProduct();
            }
            else if (jb.getText().equals("Stanza 3")) {
                i=3;
                List<Room> rooms = Manager.getRoomList();
                roomInfo.add(Manager.getRoomString(rooms.get(i-1)));
                roomInfo.add("\n\n----------------------------------\nOpere Disponibili:");
                List<Opera> artworks = Manager.getArtList();
                roomInfo.add(Manager.getAvilableOperaString((ArrayList<Opera>) artworks, i));
                dd.make("Stanza "+i, roomInfo);
                sdb.getProduct();
            }
            else if (jb.getText().equals("Stanza 4")) {
                i=4;
                List<Room> rooms = Manager.getRoomList();
                roomInfo.add(Manager.getRoomString(rooms.get(i-1)));
                roomInfo.add("\n\n----------------------------------\nOpere Disponibili:");
                List<Opera> artworks = Manager.getArtList();
                roomInfo.add(Manager.getAvilableOperaString((ArrayList<Opera>) artworks, i));
                dd.make("Stanza "+i, roomInfo);
                sdb.getProduct();
            }
//            else if (jb.getText().equals("Visualizza opere")) {
//            }
//            else if (jb.getText().equals("Modifica opera")) {
//            }
            else
                dispose();
        }
	}
}