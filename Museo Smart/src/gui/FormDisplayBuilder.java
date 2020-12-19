package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import database.Manager;
import database.Opera;


public class FormDisplayBuilder implements DisplayBuilder{

	private FormDisplay formDisplay;
	private Container c;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel bottomPanel;
	private JButton[] buttons;
	private JLabel label;
	private ArrayList<JTextField> textFields;
	private ArrayList<JTextArea> textAreas;
	private JScrollPane scrollPane;
	
	
	public FormDisplayBuilder () {
		this.reset();
	}
	
	@Override
	public void reset() {
		this.c = null;
		this.topPanel = new JPanel();
		this.bottomPanel = new JPanel();
		this.centerPanel = new JPanel();
		this.buttons = null;
		this.scrollPane = new JScrollPane();
		this.label = new JLabel();
		this.textFields = new ArrayList<>();
		this.textAreas = new ArrayList<>();
	}

	@Override
	public void createWindow(String title) {
		this.formDisplay= new FormDisplay (title);
		this.formDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.formDisplay.setSize(650, 500);
		this.formDisplay.setLocationRelativeTo(null);
	}
	

	@Override
	public void createPanel(ArrayList<String> info) {
		if (info.get(0).equals("Opera")) {
			this.c = formDisplay.getContentPane();
			this.c.setLayout(new BorderLayout());
			
			// add the topPanel to the container
			this.c.add(topPanel, BorderLayout.NORTH);
			// make the panel for the text fields
			this.topPanel.setLayout(new GridLayout(0,1));       //"GridLayout" is a LayoutManager
			this.topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			
			int artworkID = Integer.parseInt(info.get(1));
			Opera artwork = Manager.getOperaByID(artworkID);
			//this.label.setText("ID opera: "+String.valueOf(artwork.getID()));
			//this.topPanel.add(this.label);
			for (int i=0; i<7; i++) {
				this.textFields.add(new JTextField());
				this.topPanel.add(this.textFields.get(i));
			}
			this.textFields.get(0).setBorder(BorderFactory.createTitledBorder("ID"));
			this.textFields.get(0).setText(String.valueOf(artwork.getID()));
			this.textFields.get(0).setEditable(false);
			this.textFields.get(1).setBorder(BorderFactory.createTitledBorder("Titolo"));
			this.textFields.get(1).setText(artwork.getTitle());
			this.textFields.get(2).setBorder(BorderFactory.createTitledBorder("Autore"));
			this.textFields.get(2).setText(artwork.getArtist());
			this.textFields.get(3).setBorder(BorderFactory.createTitledBorder("Tipo"));
			this.textFields.get(3).setText(artwork.getType());
			this.textFields.get(4).setBorder(BorderFactory.createTitledBorder("Corrente artistica"));
			this.textFields.get(4).setText(artwork.getMovement());
			this.textFields.get(5).setBorder(BorderFactory.createTitledBorder("Stanza"));
			this.textFields.get(5).setText(String.valueOf(artwork.getRoom()));
			this.textFields.get(6).setBorder(BorderFactory.createTitledBorder("Posizione nella stanza"));
			this.textFields.get(6).setText(String.valueOf(artwork.getPosition()));
			
			// add the centerPanel panel to the container
			this.c.add(centerPanel, BorderLayout.CENTER);
			// make the panel for the text area (centerPanel)
			this.centerPanel.setLayout(new GridLayout(0,1));
			this.centerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
			this.textAreas.add(new JTextArea());
			this.textAreas.get(0).setLineWrap(true);
			this.textAreas.get(0).setText(artwork.getDescription());
			this.scrollPane.setViewportView(textAreas.get(0));
			this.scrollPane.setBorder(BorderFactory.createTitledBorder("Descrizione"));
			this.centerPanel.add(scrollPane, BorderLayout.CENTER);
			
			
			// add the bottom panel to the container
			c.add(bottomPanel, BorderLayout.SOUTH);
			// make the the panel for the buttons (bottomPanel)
			this.bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			this.bottomPanel.setLayout(new GridLayout(0,1));
		}
	}

	@Override
	public void createButtons(String... buttons) {
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
	
	public FormDisplay getProduct () {
		//return new Menu(this.panel, this.buttons);
		this.formDisplay.setButtons(this.buttons);
		this.formDisplay.setTextFields (this.textFields);
		this.formDisplay.setTextAreas (this.textAreas);
		this.formDisplay.setVisible(true);
		return this.formDisplay;
	}
}
