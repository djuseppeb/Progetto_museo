package Component;

public class Room implements Component {

	private int ID_stanza;
	private float Temperatura;
	private boolean Stato_impianto_termico;
	private int N_persone;
	private float Distanza_media;
	private boolean Distanziamento;
	private int Intensita_luci;
	
	@Override
	public int getID() {
		return this.ID_stanza;
	}
	
	public Room(int ID_stanza, float Temperatura, boolean Stato_impianto_termico, int N_persone, float Distanza_media, boolean Distanziamento, int Intensita_luci) {
		this.ID_stanza = ID_stanza;
		this.Temperatura = Temperatura;
		this.Stato_impianto_termico = Stato_impianto_termico;
		this.N_persone = N_persone;
		this.Distanza_media = Distanza_media;
		this.Distanziamento = Distanziamento;
		this.Intensita_luci = Intensita_luci;
	}
}
