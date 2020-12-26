package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EnhancedDisplayBuilder implements DisplayBuilder{

	private EnhancedDisplay enhancedDisplay;
	private Container c;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JButton[] buttons;
	private JTextArea textArea;
	private JTextField textField;
	private JScrollPane scrollPane;
	
	
	public EnhancedDisplayBuilder () {
		this.reset();
	}
	
	@Override
	public void reset(){
		this.c = null;
		this.topPanel = new JPanel();
		this.bottomPanel = new JPanel();
		this.buttons = null;
		this.textArea = new JTextArea();
		this.scrollPane = new JScrollPane();
		this.textField = new JTextField();
	}

	@Override
	public void createWindow (String title) {
		this.enhancedDisplay= new EnhancedDisplay (title);
		//this.menu.setTitle(title);
		//this.menu.setSize(width, height);
		this.enhancedDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.enhancedDisplay.setSize(650, 450);
		this.enhancedDisplay.setLocationRelativeTo(null);
	}
	
	/*
	@Override
	public void createPanel(ArrayList<String> info) {
		this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		this.panel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
		for (String i : info)
			this.textArea.append(i);
		this.textArea.setEditable(false);
		this.panel.add(this.textArea);
		this.panel.add(this.textField);
		this.enhancedDisplay.add(this.panel, BorderLayout.CENTER);
		

	}
	*/
	
	public void createPanel (ArrayList<String> info) {
        //this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        //this.enhancedDisplay.setLayout(new BorderLayout());  //"BorderLayout" is a LayoutManager
        this.c = this.enhancedDisplay.getContentPane();
        this.c.setLayout(new BorderLayout());  //"BorderLayout" is a LayoutManager
        this.c.add(this.topPanel, BorderLayout.NORTH);
        this.topPanel.setLayout(new BorderLayout());
        this.topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (String i : info)
            this.textArea.append(i);
        this.textArea.setEditable(false);
        this.enhancedDisplay.add(this.topPanel);
        this.scrollPane.setViewportView(textArea);
        this.scrollPane.setBorder(BorderFactory.createTitledBorder("Informazioni"));
        //this.scrollPane.setPreferredSize(new Dimension(580,350));
        this.topPanel.add(this.scrollPane, BorderLayout.CENTER);
        this.c.add(this.bottomPanel, BorderLayout.SOUTH);
       // this.bottomPanel.setLayout(new GridLayout(0,1));
        this.bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        this.textField.setBorder(BorderFactory.createTitledBorder("Digita ID"));
        this.textField.setPreferredSize(new Dimension(130,50));
        this.bottomPanel.add(this.textField);
    }
	/*
	public void createPanel (ArrayList<String> info) {
        //this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		//this.enhancedDisplay.setLayout(new BorderLayout());  //"BorderLayout" is a LayoutManager
        this.c = this.enhancedDisplay.getContentPane();
        this.c.setLayout(new BorderLayout());  //"BorderLayout" is a LayoutManager
        this.c.add(this.topPanel, BorderLayout.NORTH);
		this.topPanel.setLayout(new BorderLayout());
		this.topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (String i : info)
        	this.textArea.append(i);
        this.textArea.setEditable(false);
        this.enhancedDisplay.add(this.topPanel);
        this.scrollPane.setViewportView(textArea);
        this.scrollPane.setBorder(BorderFactory.createTitledBorder("Informazioni"));
        //this.scrollPane.setPreferredSize(new Dimension(580,350));
        this.topPanel.add(this.scrollPane, BorderLayout.CENTER);
        this.c.add(this.bottomPanel, BorderLayout.SOUTH);
        this.bottomPanel.setLayout(new GridLayout(0,1));
        this.bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        this.bottomPanel.add(this.textField, BorderLayout.SOUTH);
    }
	*/
	
	@Override
	public void createButtons (String... buttons) {
		
		this.buttons = new JButton [buttons.length+1];
		
		for ( int i=0; i<=buttons.length; i++ ) {
			if ( i<buttons.length )
				this.buttons[i] = new JButton(buttons[i]);
			else
				this.buttons[i] = new JButton("TORNA INDIETRO");
			this.buttons[i].setPreferredSize(new Dimension(200,50));
			this.bottomPanel.add(this.buttons[i]);
		}

	}	

	
	public EnhancedDisplay getProduct () {
		//return new Menu(this.panel, this.buttons);
		this.enhancedDisplay.setButtons(this.buttons);
		this.enhancedDisplay.setTextField(this.textField);
		this.enhancedDisplay.setVisible(true);
		return this.enhancedDisplay;
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
	
	public JTextArea getTextArea () {
		return this.textArea;
	}
	
	public JTextField getTextField () {
		return this.textField;
	}
	
	public JScrollPane getScrollPane () {
		return this.scrollPane;
	}
	
	public EnhancedDisplay getEnhancedDisplay () {
		return this.enhancedDisplay;
	}

}
