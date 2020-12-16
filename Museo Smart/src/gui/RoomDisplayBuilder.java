package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class RoomDisplayBuilder implements DisplayBuilder{

	private RoomDisplay roomDisplay;
	private JPanel panel;
	private JButton[] buttons;
	private JTextArea textArea = new JTextArea();
	
	public RoomDisplayBuilder () {
		this.reset();
	}
	
	@Override
	public void reset(){
		this.panel = new JPanel();
		this.buttons = null;
	}

	@Override
	public void createWindow (String title) {
		this.roomDisplay= new RoomDisplay (title);
		//this.menu.setTitle(title);
		//this.menu.setSize(width, height);
		this.roomDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.roomDisplay.setSize(600, 400);
		this.roomDisplay.setLocationRelativeTo(null);
	}
	
	@Override
	public void createPanel (String info) {
		this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		this.panel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
		this.textArea.setText(info);
		this.textArea.setEditable(false);
		this.panel.add(this.textArea);
		this.roomDisplay.add(this.panel, BorderLayout.CENTER);
		

	}
	
	@Override
	public void createButtons (String... buttons) {
		
		
		this.buttons = new JButton [buttons.length+1];
		
		for ( int i=0; i<=buttons.length; i++ ) {
			if ( i<buttons.length )
				this.buttons[i] = new JButton(buttons[i]);
			else
				this.buttons[i] = new JButton("HOME");
			this.buttons[i].setPreferredSize(new Dimension(100,50));
			this.panel.add(this.buttons[i]);
		}

	}	

	
	public RoomDisplay getProduct () {
		//return new Menu(this.panel, this.buttons);
		this.roomDisplay.setButtons(this.buttons);
		this.roomDisplay.setVisible(true);
		return this.roomDisplay;
	}
}
