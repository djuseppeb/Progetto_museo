package Component;

public class Opera implements Component {
	
	private int ID_opera;
	private String Titolo;
	private String Autore;
	private String Disponibilita;
	private String Tipo;
	private int Stanza;
	private String Corrente_artistica;
	private String Descrizione;
	private int Posizione;
	private int Valore_euro;

	@Override
	public int getID() {
		return this.ID_opera;
	}
	
	public Opera(int ID_opera, String Titolo, String Autore, String Disponibilita, String Tipo, int Stanza, String Corrente_artistica, String Descrizione, int Posizione, int Valore_euro) {
		this.ID_opera = ID_opera;
		this.Titolo = Titolo;
		this.Autore = Autore;
		this.Disponibilita = Disponibilita;
		this.Tipo = Tipo;
		this.Stanza = Stanza;
		this.Corrente_artistica = Corrente_artistica;
		this.Descrizione = Descrizione;
		this.Posizione = Posizione;
		this.Valore_euro = Valore_euro;
	}
}
