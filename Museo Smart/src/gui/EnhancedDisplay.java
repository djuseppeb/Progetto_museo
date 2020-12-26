package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.Manager;
import database.Opera;


public class EnhancedDisplay extends JFrame{
	
	private JButton[] buttons;
	private JTextField textField;
	private MyActionListener l = new MyActionListener();
	private FormDisplayBuilder fdb = new FormDisplayBuilder();   // create an FormDisplayBuilder
	private DisplayDirector dd = new DisplayDirector(fdb);        // create a DisplayDirector


	public EnhancedDisplay (String title) {
		super(title);
	}
	
	
	public void setButtons (JButton[] buttons) {
		this.buttons=buttons;
		for ( int i=0; i<this.buttons.length; i++ )
			this.buttons[i].addActionListener(this.l);
	}
	
	public void setTextField (JTextField textField) {
		this.textField=textField;
	}
	
	public JButton[] getButtons() {
		return this.buttons;
	}
	
	public JTextField getTextField() {
		return this.textField;
	}

	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton)e.getSource();
			if (jb.getText().equals("Visualizza")) {
								
				// creare qua la schermata di visualizzazione opera
				int chosenID = Integer.parseInt(textField.getText());
				if (Manager.operaExists(chosenID)) {
					//System.out.println(textField.getText());
					
					ArrayList<String> info = new ArrayList<>();
					info.add("Opera");
					info.add(textField.getText());
					dd.make("Dettagli opera "+chosenID, info, "Salva modifiche");
					fdb.getProduct();
					
				}
				else {
					JOptionPane.showMessageDialog(null,
						    "L'ID inserito non corrisponde a nessuna opera.",
						    "ID non valido",
						    JOptionPane.WARNING_MESSAGE);

				}
					
			}
			else
				dispose();
		}

	}
	
}
