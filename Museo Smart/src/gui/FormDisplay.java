package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import database.OperaCreator;


public class FormDisplay  extends JFrame {
	private JButton[] buttons;
	private ArrayList<JTextField> textFields;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private MyActionListener l = new MyActionListener();
	
	
	public FormDisplay (String title) {
		super(title);
	}
	
	
	public void setButtons (JButton[] buttons) {
		this.buttons=buttons;
		for ( int i=0; i<this.buttons.length; i++ )
			this.buttons[i].addActionListener(this.l);
	}
	
	
	public void setTextFields (ArrayList<JTextField> textFields) {
		this.textFields = textFields;
	}
	
	
	public void setScrollPane (JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	
	
	public void setTextArea (JTextArea textArea) {
		this.textArea = textArea;
	}
	
	
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton)e.getSource();
			if (jb.getText().equals("Salva modifiche") && getTitle().contains("opera")) {
				// update database
				String errors = "";
				OperaCreator oC = new OperaCreator();
				int artworkID = Integer.parseInt(textFields.get(0).getText());
				for (JTextField textField : textFields) {
					Border border = textField.getBorder();
					// make sure to update the right field in the database
					if (((TitledBorder)border).getTitle().equals("Titolo")) {
						if ( ! oC.updateTitle(artworkID, textField.getText()))
							errors+="- Titolo\n";
					}
					else if (((TitledBorder)border).getTitle().equals("Autore")) {
						if ( ! oC.updateArtist(artworkID, textField.getText()))
							errors+="- Autore\n";
					}
					else if (((TitledBorder)border).getTitle().equals("Tipo")) {
						if ( ! oC.updateType(artworkID, textField.getText()))
							errors+="- Tipo\n";
					}
					else if (((TitledBorder)border).getTitle().equals("Corrente artistica")) {
						if ( ! oC.updateMovement(artworkID, textField.getText()))
							errors+="- Corrente artistica\n";
					}
					else if (((TitledBorder)border).getTitle().equals("Stanza")) {
						if ( ! oC.updateRoom(artworkID, Integer.parseInt(textField.getText())))
							errors+="- Stanza\n";
					}
					else if (((TitledBorder)border).getTitle().equals("Posizione nella stanza")) {
						if ( ! oC.updatePosition(artworkID, Integer.parseInt(textField.getText())))
							errors+="- Posizione nella stanza\n";
					}
				}
				
				/*
				for (JTextField textField : textFields) {
					Border border = textField.getBorder();
					// make sure to update the right field in the database
					if (((TitledBorder)border).getTitle().equals("Titolo"))
						oC.updateTitle(artworkID, textField.getText());
					
					else if (((TitledBorder)border).getTitle().equals("Autore"))
						oC.updateArtist(artworkID, textField.getText());
							
					else if (((TitledBorder)border).getTitle().equals("Tipo"))
						oC.updateType(artworkID, textField.getText());
							
					else if (((TitledBorder)border).getTitle().equals("Corrente artistica"))
						oC.updateMovement(artworkID, textField.getText());
						
					else if (((TitledBorder)border).getTitle().equals("Stanza"))
						oC.updateRoom(artworkID, Integer.parseInt(textField.getText()));
							
					else if (((TitledBorder)border).getTitle().equals("Posizione nella stanza"))
						oC.updatePosition(artworkID, Integer.parseInt(textField.getText()));
							
				}*/
								
				Border border = scrollPane.getBorder();
				// make sure to update the right field in the database
				if (((TitledBorder)border).getTitle().equals("Descrizione"))
					if ( ! oC.updateDescription(artworkID, textArea.getText()) )
						errors+="- Descrizione\n";
				
				if (errors.length() > 0) {
					JOptionPane.showMessageDialog(null,
						    "Non è stato possibile aggiornare i seguenti campi dell'opera:\n"+errors,
						    "Errori in alcuni campi",
						    JOptionPane.WARNING_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null,
						    "Tutti i campi sono stati aggiornati correttamente!",
						    "Salvataggio completato!",
						    JOptionPane.INFORMATION_MESSAGE);
					
				
				
			}
			else
				dispose();
		}

	}
}
