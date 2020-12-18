package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubMenuBuilder implements MenuBuilder{

	private SubMenu subMenu;
	private Container c;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JButton[] buttons;
	
	public SubMenuBuilder () {
		this.reset();
	}
	
	@Override
	public void reset(){
		this.c = null;
		this.topPanel = new JPanel();
		this.bottomPanel = new JPanel();
		this.buttons = null;
	}

	@Override
	public void createWindow (String title) {
		this.subMenu = new SubMenu (title);
		//this.menu.setTitle(title);
		//this.menu.setSize(width, height);
		this.subMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.subMenu.setSize(650, 450);
		this.subMenu.setLocationRelativeTo(null);
	}
	
	/*
	@Override
	public void createPanel () {
		this.panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
		this.panel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
		this.subMenu.add(this.panel, BorderLayout.CENTER);
	}
	*/
	
	@Override
	public void createPanel () {
		c = subMenu.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(topPanel, BorderLayout.CENTER);
		this.topPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
		this.topPanel.setLayout(new GridLayout(2,2));       //"GridLayout" is a LayoutManager
		//this.mainMenu.add(this.panel, BorderLayout.CENTER);
		c.add(bottomPanel, BorderLayout.SOUTH);
		this.bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
		this.bottomPanel.setLayout(new GridLayout(0,1));
		
	}
	
	@Override
	public void createButtons (String... buttons) {
		
		
		this.buttons = new JButton [buttons.length+1];
		
		for ( int i=0; i<=buttons.length; i++ ) {
			if ( i<buttons.length ) {
				this.buttons[i] = new JButton(buttons[i]);
				this.topPanel.add(this.buttons[i]);
			}
			else {
				this.buttons[i] = new JButton("TORNA INDIETRO");
				this.buttons[i].setPreferredSize(new Dimension(300, 50));
				this.bottomPanel.add(this.buttons[i]);
				//this.buttons[i].setPreferredSize(new Dimension(100,50));
				//this.panel.add(this.buttons[i]);
			}
		}

	}	

	
	public SubMenu getProduct () {
		//return new Menu(this.panel, this.buttons);
		this.subMenu.setButtons(this.buttons);
		this.subMenu.setVisible(true);
		return this.subMenu;
	}

}
