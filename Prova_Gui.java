import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Prova_Gui extends JFrame {
	private JButton Stanza_1 = new JButton("Stanza n.1");
	private JButton Stanza_2 = new JButton("Stanza n.2");
	private JButton Stanza_3 = new JButton("Stanza n.3");
	private JButton Stanza_4 = new JButton("Stanza n.4");
	private JPanel pan = new JPanel();
	private JTextArea text = new JTextArea();
	
	public Prova_Gui () {
        super("Schermata di navigazione tra le stanze"); //Nome finestra
        Container c = this.getContentPane();	
		c.add(pan);										
		
		//Aggiunta delle varie componenti al pannello
		pan.add(Stanza_1);
		Stanza_1.setPreferredSize(new Dimension(100,50));
		pan.add(Stanza_2);		
		Stanza_2.setPreferredSize(new Dimension(100,50));
		pan.add(Stanza_3);
		Stanza_3.setPreferredSize(new Dimension(100,50));
		pan.add(Stanza_4);		
		Stanza_4.setPreferredSize(new Dimension(100,50));
		
		//Ascoltatore MouseListener per gestire i click sui bottoni
		Stanza_1.addMouseListener(new MioMouseListener());
		Stanza_2.addMouseListener(new MioMouseListener());
		Stanza_3.addMouseListener(new MioMouseListener());
		Stanza_4.addMouseListener(new MioMouseListener());
		
		this.pack();	//Settaggio dimensioni ideali
		this.setLocationRelativeTo(null);	//Settaggio finestra al centro dello schermo
		this.setVisible(true);				//Rendi visibile finestra
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Termina alla chiusura della finestra
	}
	
	class MioMouseListener implements MouseListener {   //Classe Inner che implementa l'ascoltatore MouseListener
	
		@Override public void mouseClicked(MouseEvent e) {
			int i=0;
	        JButton bnEvent=(JButton)e.getSource();			//Per capire quale tasto si sta schiacciando
	        if(bnEvent.getText().equals("Stanza n.1")) {
	        	i=0;
	        }else if(bnEvent.getText().equals("Stanza n.2")) {
	        	i=1;
	        }else if(bnEvent.getText().equals("Stanza n.3")) {
	        	i=2;
	        }else if(bnEvent.getText().equals("Stanza n.4")) {
	        	i=3;
	        }
				JFrame f = new JFrame ("Finestra Stanza"+" "+(i+1));	//Creazione della finestra successiva al click sul determinato bottone
				Container c2 = null;
				c2 = f.getContentPane();
				c2.setLayout(new BorderLayout());
				c2.add(text,BorderLayout.NORTH);
				try {
					text.setText("Nella stanza"+" "+(i+1)+" sono presenti le seguenti informazioni : "+"\n"+"Temperatura : "+Get_Temperature()[i]+"\n"+"N.Persone : "+Get_NumeroPersone()[i]+"\n"+"Distanza Media : "+Get_DistanzaMedia()[i]+"\n"+"Impianto Termico : "+Get_ImpiantoTermico()[i]+"\n"+"Distanziamento : "+Get_Distanziamento()[i]);                        
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				text.setEditable(false);		//Rendi testo del JTextArea non editabile
				f.setBounds(300,200,400,150);	//Setta dimensioni finestra
				f.setVisible(true);				//Rendi visibile
	        
		}
		//Metodi di MouseListener non implementati
		@Override								
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	
	//Metodo per ottenere le temperature delle stanze
	public static String[] Get_Temperature () throws SQLException {		
		String[] v = new String[4];
		int i=0;
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/gestione_museo";
		String user = "root";
		String pwd = "";
		
		try {
			connection = DriverManager.getConnection(url,user,pwd);
			//System.out.println("Succesfully connected to database.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement st = connection.createStatement();
		String q = "SELECT Temperatura FROM stanza";
		ResultSet rs = st.executeQuery(q);
		
		while(rs.next()) {
			//System.out.println(rs.getString(1));
			v[i] = rs.getString(1);
			i++;
		}
		return v;
	}
	//Metodo per ottenere il numero di persone all'interno di ogni stanza
	public static String[] Get_NumeroPersone () throws SQLException {
		String[] v = new String[4];
		int i=0;
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/gestione_museo";
		String user = "root";
		String pwd = "";
		
		try {
			connection = DriverManager.getConnection(url,user,pwd);
			//System.out.println("Succesfully connected to database.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement st = connection.createStatement();
		String q = "SELECT N_persone FROM stanza";
		ResultSet rs = st.executeQuery(q);
		
		while(rs.next()) {
			//System.out.println(rs.getString(1));
			v[i] = rs.getString(1);
			i++;
		}
		return v;
	}
	//Metodo per ottenere la distanza media tra le persone in ogni stanza
	public static String[] Get_DistanzaMedia() throws SQLException {
		String[] v = new String[4];
		int i=0;
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/gestione_museo";
		String user = "root";
		String pwd = "";
		
		try {
			connection = DriverManager.getConnection(url,user,pwd);
			//System.out.println("Succesfully connected to database.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement st = connection.createStatement();
		String q = "SELECT Distanza_media FROM stanza";
		ResultSet rs = st.executeQuery(q);
		
		while(rs.next()) {
			v[i] = rs.getString(1);
			i++;
		}
		return v;
	}
	
	//Metodo per ottenere il livello di intensità delle luci in ogni stanza
	public static String[] Get_IntensitaLuci () throws SQLException {
		String[] v = new String[4];
		int i=0;
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/gestione_museo";
		String user = "root";
		String pwd = "";
		
		try {
			connection = DriverManager.getConnection(url,user,pwd);
			//System.out.println("Succesfully connected to database.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement st = connection.createStatement();
		String q = "SELECT Intensita_luci FROM stanza";
		ResultSet rs = st.executeQuery(q);
		
		while(rs.next()) {
			//System.out.println(rs.getString(1));
			v[i] = rs.getString(1);
			i++;
		}
		return v;
	}
	
	//Metodo per capire se l'impianto termico è acceso o spento nelle varie stanze
	public static String[] Get_ImpiantoTermico () throws SQLException {
		String[] v = new String[4];
		int i=0;
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/gestione_museo";
		String user = "root";
		String pwd = "";
		
		try {
			connection = DriverManager.getConnection(url,user,pwd);
			//System.out.println("Succesfully connected to database.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement st = connection.createStatement();
		String q = "SELECT Stato_impianto_termico FROM stanza";
		ResultSet rs = st.executeQuery(q);
		while(rs.next()) {
			if(rs.getString(1).equals("1")) {
				v[i] = "acceso";
			}else {
				v[i] = "spento";
			}
			i++;
		}
		return v;
	}
	
	//Metodo per capire se il distanziamento tra le persone è rispettato o meno nelle varie stanze
	public static String[] Get_Distanziamento () throws SQLException {
		String[] v = new String[4];
		int i=0;
		Connection connection = null;
		String url = "jdbc:mariadb://localhost:3306/gestione_museo";
		String user = "root";
		String pwd = "";
		
		try {
			connection = DriverManager.getConnection(url,user,pwd);
			//System.out.println("Succesfully connected to database.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement st = connection.createStatement();
		String q = "SELECT Distanziamento FROM stanza";
		ResultSet rs = st.executeQuery(q);
		while(rs.next()) {
			if(rs.getString(1).equals("1")) {
				v[i] = "rispettato";
			}else {
				v[i] = "non rispettato";
			}
			i++;
		}
		return v;
	}
	
	
	public static void main(String[] args) throws SQLException {
    	Prova_Gui p = new Prova_Gui();
    }
}
