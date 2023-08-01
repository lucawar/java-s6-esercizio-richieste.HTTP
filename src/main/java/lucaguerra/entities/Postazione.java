package lucaguerra.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lucaguerra.ENUM.TipoPostazione;

@Getter
@Setter
@ToString
public class Postazione {

	private int id;
	private String descrizione;
	private int numerMaxOccupanti;
	private boolean disponibilita;
	private TipoPostazione tipoPostazione;
	private String citta;
	private Prenotazione prenotazione;

	public Postazione(int id, String descrizione, int numerMaxOccupanti, boolean disponibilita,
			TipoPostazione tipoPostazione, String citta) {

		this.id = id;
		this.descrizione = descrizione;
		this.numerMaxOccupanti = numerMaxOccupanti;
		this.disponibilita = disponibilita;
		this.tipoPostazione = tipoPostazione;
		this.citta = citta;
	}

}
