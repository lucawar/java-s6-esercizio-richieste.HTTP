package lucaguerra.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lucaguerra.ENUM.TipoPostazione;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class NewPostazionePayload {

	private String descrizione;
	private int numerMaxOccupanti;
	private TipoPostazione tipoPostazione;
	private String citta;
}
