package lucaguerra.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prenotazione {

	@Id
	@GeneratedValue
	private int id;
	private LocalDate dataPrenotazione;
	@OneToOne
	private Postazione postazione;
	@ManyToOne
	private User user;

	public Prenotazione(int id, LocalDate dataPrenotazione, Postazione postazione, User user) {

		this.id = id;
		this.dataPrenotazione = dataPrenotazione;
		this.postazione = postazione;
		this.user = user;
	}

}
