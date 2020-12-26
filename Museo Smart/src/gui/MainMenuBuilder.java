package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainMenuBuilder implements MenuBuilder{
	
	private MainMenu mainMenu;
	private Container c;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JButton[] buttons;
	//private JLabel img;
	//private Image img;
	
	
	public MainMenuBuilder () {
		this.reset();
	}
	
	@Override
	public void reset(){
		this.c = null;
		this.topPanel = new JPanel();
		this.bottomPanel = new JPanel();
		this.buttons = null;
		//this.img = new JLabel("");
		//this.img = Toolkit.getDefaultToolkit().createImage("../controlpanel2.jpg");
	}

	@Override
	public void createWindow (String title) {
		this.mainMenu = new MainMenu (title);
		//this.menu.setTitle(title);
		//this.menu.setSize(width, height);
		this.mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainMenu.setSize(650, 450);
		//this.mainMenu.setResizable(false);
		this.mainMenu.setLocationRelativeTo(null);
	}
	
	/*
	@Override
	public void createPanel () {
		this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		this.panel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
		this.mainMenu.add(this.panel, BorderLayout.CENTER);
	}
	*/
	
	@Override
	public void createPanel () {
		c = mainMenu.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(topPanel, BorderLayout.CENTER);
		this.topPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
		this.topPanel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
		//this.mainMenu.add(this.panel, BorderLayout.CENTER);
		c.add(bottomPanel, BorderLayout.SOUTH);
		this.bottomPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 10, 10));
		this.bottomPanel.setLayout(new GridLayout(0,1));
		
	}
	
	
	
	/*
	@Override
	public void createPanel () {
		//this.mainMenu.setLayout(new BorderLayout());
		img.setIcon(new ImageIcon(mainMenuBuilder.class.getResource("/controlpanel2.jpg")));
		img.setSize(500,400);
		
		this.c = this.mainMenu.getContentPane();
		this.c.add(img);
		this.c.setLayout(new BorderLayout());
        this.c.add(this.topPanel, BorderLayout.NORTH);
        //this.topPanel.setLayout(new FlowLayout());
		this.topPanel.setBorder(BorderFactory.createEmptyBorder(130, 10, 10, 10));
		this.mainMenu.add(this.topPanel);
		this.c.add(this.bottomPanel, BorderLayout.SOUTH);
		//this.bottomPanel.setLayout(new BorderLayout());
        this.bottomPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
        
		//this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		//this.panel.setLayout(new GridLayout(2,2));       //"GridLayout" is a LayoutManager
		//this.mainMenu.add(this.panel, BorderLayout.CENTER);
		//this.mainMenu.add(this.panel);
		//img.setIcon(new ImageIcon(mainMenuBuilder.class.getResource("../controlpanel2.jpg")));
		//img.setSize(500,400);
		//this.panel.setLayout(null);
		
		//this.mainMenu.add(this.panel);
	}
	*/
	
	
	/*
	@Override
	public void createPanel () {
		//this.mainMenu.setLayout(new BorderLayout());
		img.setIcon(new ImageIcon(mainMenuBuilder.class.getResource("/controlpanel2.jpg")));
		img.setSize(500,400);
		
		this.c = this.mainMenu.getContentPane();
		this.c.add(img);
		this.c.setLayout(new BorderLayout());
        this.c.add(this.topPanel, BorderLayout.CENTER);
        //this.topPanel.setLayout(new FlowLayout());
		this.topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		//this.mainMenu.add(this.topPanel);
		//this.c.add(this.bottomPanel, BorderLayout.SOUTH);
		//this.bottomPanel.setLayout(new BorderLayout());
        //this.bottomPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
        
		//this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		//this.panel.setLayout(new GridLayout(2,2));       //"GridLayout" is a LayoutManager
		//this.mainMenu.add(this.panel, BorderLayout.CENTER);
		//this.mainMenu.add(this.panel);
		//img.setIcon(new ImageIcon(mainMenuBuilder.class.getResource("../controlpanel2.jpg")));
		//img.setSize(500,400);
		//this.panel.setLayout(null);
		
		//this.mainMenu.add(this.panel);
	}*/

	
	/*
	public void createPanel () {
		//this.mainMenu.setLayout(new BorderLayout());
		img.setIcon(new ImageIcon(mainMenuBuilder.class.getResource("/controlpanel2.jpg")));
		img.setSize(500,400);
		//this.panel.setLayout(null);
		
		this.c = this.mainMenu.getContentPane();
		
		//this.mainMenu.add(img);
		//////this.c.setLayout(new BorderLayout());
        //////this.c.add(this.topPanel, BorderLayout.NORTH);
        //this.topPanel.setLayout(new FlowLayout());
		//////this.topPanel.setBorder(BorderFactory.createEmptyBorder(130, 10, 10, 10));
		//this.mainMenu.add(this.topPanel);
		//////this.c.add(this.bottomPanel, BorderLayout.SOUTH);
		//this.bottomPanel.setLayout(new BorderLayout());
        //////this.bottomPanel.setBorder(BorderFactory.createEmptyBorder(1, 10, 10, 10));
		//this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		//this.panel.setLayout(new GridLayout(2,2));       //"GridLayout" is a LayoutManager
		//this.mainMenu.add(this.panel, BorderLayout.CENTER);
		//this.mainMenu.add(this.panel);
		
		//this.mainMenu.add(this.panel);
	}*/
	
	/*
	@Override
	public void createPanel () {
		//this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		//this.panel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
		//this.mainMenu.add(this.panel, BorderLayout.CENTER);
		this.mainMenu.add(this.topPanel);
		//JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(mainMenuBuilder.class.getResource("/controlpanel2.jpg")));
		img.setSize(500,400);
		this.topPanel.setLayout(null);
		this.topPanel.add(img);
		this.mainMenu.add(this.topPanel);
	}
	*/
	
	
	@Override
	public void createButtons (String... buttons) {
			
		this.buttons = new JButton [buttons.length+1];
		
		for ( int i=0; i<=buttons.length; i++ ) {
			if ( i<buttons.length ) {
				this.buttons[i] = new JButton(buttons[i]);
				//this.buttons[i].setPreferredSize(new Dimension(300, 100));
				this.topPanel.add(this.buttons[i]);
			}
			else {
				this.buttons[i] = new JButton("CHIUDI");
				this.buttons[i].setPreferredSize(new Dimension(300, 50));
				this.bottomPanel.add(this.buttons[i]);
			}
			
		}

	}	
	
	
	public MainMenu getProduct () {
		//return new Menu(this.panel, this.buttons);
		this.mainMenu.setButtons(this.buttons);
		this.mainMenu.setVisible(true);
		return this.mainMenu;
	}
	
	public Container getC () {
		return this.c;
	}
	
	public JPanel getTopPanel () {
		return this.topPanel;
	}
	
	public JPanel getBottomPanel () {
		return this.bottomPanel;
	}
	
	public JButton[] getButtons () {
		return this.buttons;
	}
	
	public MainMenu getMainMenu () {
		return this.mainMenu;
	}

}
