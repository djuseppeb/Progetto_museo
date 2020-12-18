package gui;

import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FormDisplayBuilder implements DisplayBuilder{

	private FormDisplay formDisplay;
	private Container c;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JButton[] buttons;
	private JTextField textField;
	private JScrollPane scrollPane;
	
	
	public FormDisplayBuilder () {
		this.reset();
	}
	/*
	@Override
	public void reset() {
		this.c = null;
		this.topPanel = new JPanel();
		this.bottomPanel = new JPanel();
		this.buttons = null;
		this.scrollPane = new JScrollPane();
		this.textField = new JTextField();
	}

	@Override
	public void createWindow(String title) {
		this.formDisplay= new FormDisplay (title);
		this.formDisplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.formDisplay.setSize(650, 450);
		this.formDisplay.setLocationRelativeTo(null);
	}
	

	@Override
	public void createPanel(ArrayList<String> info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createButtons(String... buttons) {
		// TODO Auto-generated method stub
		
	}
*/


	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createWindow(String title) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createPanel(ArrayList<String> info) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void createButtons(String... buttons) {
		// TODO Auto-generated method stub
		
	}
}
