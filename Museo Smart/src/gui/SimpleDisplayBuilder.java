package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimpleDisplayBuilder implements DisplayBuilder{

	private SimpleDisplay simpleDisplay;
	private Container c;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JButton[] buttons;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	public SimpleDisplayBuilder () {
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
	}

	@Override
	public void createWindow (String title) {
		this.simpleDisplay= new SimpleDisplay (title);
		this.simpleDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.simpleDisplay.setSize(650, 450);
		this.simpleDisplay.setLocationRelativeTo(null);
	}
	
	/*
	@Override
	public void createPanel (String info) {
		this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		this.panel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
		this.textArea.setText(info);
		this.textArea.setEditable(false);
		this.panel.add(this.textArea);
		this.simpleDisplay.add(this.panel, BorderLayout.CENTER);
	}
	*/
	@Override
    public void createPanel (ArrayList<String> info) {
        //this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		//this.simpleDisplay.setLayout(new BorderLayout());  //"BorderLayout" is a LayoutManager
        this.c = this.simpleDisplay.getContentPane();
        this.c.setLayout(new BorderLayout());  //"BorderLayout" is a LayoutManager
        this.c.add(this.topPanel, BorderLayout.NORTH);
        this.topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.topPanel.setLayout(new BorderLayout());
        for (String i : info)
        	this.textArea.append(i);
        this.textArea.setEditable(false);
        this.simpleDisplay.add(this.topPanel);
        this.scrollPane.setViewportView(textArea);
        this.scrollPane.setBorder(BorderFactory.createTitledBorder("Informazioni"));
        //this.scrollPane.setPreferredSize(new Dimension(580,350));
        this.topPanel.add(this.scrollPane, BorderLayout.CENTER);
        this.c.add(this.bottomPanel, BorderLayout.SOUTH);
    }
	
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

	
	public SimpleDisplay getProduct () {
		//return new Menu(this.panel, this.buttons);
		this.simpleDisplay.setButtons(this.buttons);
		this.simpleDisplay.setVisible(true);
		return this.simpleDisplay;
	}
}
