package lucaguerra.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lucaguerra.ENUM.TipoPostazione;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Postazione {

	@Id
	@GeneratedValue
	private int id;
	private String descrizione;
	private int numerMaxOccupanti;
	private TipoPostazione tipoPostazione;
	private String citta;

	public Postazione(String descrizione, int numerMaxOccupanti, TipoPostazione tipoPostazione, String citta) {

		this.descrizione = descrizione;
		this.numerMaxOccupanti = numerMaxOccupanti;
		this.tipoPostazione = tipoPostazione;
		this.citta = citta;
	}

}
