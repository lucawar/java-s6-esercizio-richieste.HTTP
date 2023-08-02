package lucaguerra.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lucaguerra.ENUM.TipoPostazione;

@Getter
@AllArgsConstructor
@ToString
public class NewPostazionePayload {

	private String descrizione;
	private int numerMaxOccupanti;
	private boolean disponibilita;
	private TipoPostazione tipoPostazione;
	private String citta;
}
