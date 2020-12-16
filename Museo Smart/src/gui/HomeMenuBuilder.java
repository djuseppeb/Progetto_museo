package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class HomeMenuBuilder implements MenuBuilder{
	
	private HomeMenu homeMenu;
	private JPanel panel;
	private JButton[] buttons;
	
	public HomeMenuBuilder () {
		this.reset();
	}
	
	@Override
	public void reset(){
		this.panel = new JPanel();
		this.buttons = null;
	}

	@Override
	public void createWindow (String title) {
		this.homeMenu = new HomeMenu (title);
		//this.menu.setTitle(title);
		//this.menu.setSize(width, height);
		this.homeMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.homeMenu.setSize(600, 400);
		this.homeMenu.setLocationRelativeTo(null);
	}
	
	@Override
	public void createPanel () {
		this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		this.panel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
		this.homeMenu.add(this.panel, BorderLayout.CENTER);
		

	}
	
	@Override
	public void createButtons (String... buttons) {
		
		
		this.buttons = new JButton [buttons.length+1];
		
		for ( int i=0; i<=buttons.length; i++ ) {
			if ( i<buttons.length )
				this.buttons[i] = new JButton(buttons[i]);
			else
				this.buttons[i] = new JButton("CHIUDI");
			this.buttons[i].setPreferredSize(new Dimension(100,50));
			this.panel.add(this.buttons[i]);
		}

	}	

	
	public HomeMenu getProduct () {
		//return new Menu(this.panel, this.buttons);
		this.homeMenu.setButtons(this.buttons);
		return this.homeMenu;
	}

}