package lucaguerra.entities;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Prenotazione {

	private int id;
	private LocalDate dataPrenotazione;
	private Postazione postazione;
	private User user;

	public Prenotazione(int id, LocalDate dataPrenotazione, Postazione postazione, User user) {

		this.id = id;
		this.dataPrenotazione = dataPrenotazione;
		this.postazione = postazione;
		this.user = user;
	}

}
