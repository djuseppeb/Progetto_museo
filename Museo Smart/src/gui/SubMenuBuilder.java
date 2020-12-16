package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubMenuBuilder implements MenuBuilder{

	private SubMenu subMenu;
	private JPanel panel;
	private JButton[] buttons;
	
	public SubMenuBuilder () {
		this.reset();
	}
	
	@Override
	public void reset(){
		this.panel = new JPanel();
		this.buttons = null;
	}

	@Override
	public void createWindow (String title) {
		this.subMenu = new SubMenu (title);
		//this.menu.setTitle(title);
		//this.menu.setSize(width, height);
		this.subMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.subMenu.setSize(600, 400);
		this.subMenu.setLocationRelativeTo(null);
	}
	
	@Override
	public void createPanel () {
		this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		this.panel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
		this.subMenu.add(this.panel, BorderLayout.CENTER);
		

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

	
	public SubMenu getProduct () {
		//return new Menu(this.panel, this.buttons);
		this.subMenu.setButtons(this.buttons);
		this.subMenu.setVisible(true);
		return this.subMenu;
	}

}
