package lucaguerra.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucaguerra.entities.NewPrenotazioneBody;
import lucaguerra.entities.Postazione;
import lucaguerra.entities.Prenotazione;
import lucaguerra.entities.User;

@Service
public class PrenotazioniService {

	private List<Prenotazione> prenotazioni = new ArrayList<>();

	@Autowired
	UsersService utenteService;

	@Autowired
	PostazioniService postazioneService;

	public Prenotazione save(NewPrenotazioneBody newPrenotazione) {

		int userId = newPrenotazione.getUserId();
		int postazioneId = newPrenotazione.getPostazioneId();
		LocalDate dataPrenotazione = newPrenotazione.getData();

		User user = utenteService.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("Utente non trovato"));
		Postazione postazione = postazioneService.findById(postazioneId)
				.orElseThrow(() -> new IllegalArgumentException("Postazione non trovata"));

		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.getDataPrenotazione().equals(dataPrenotazione)) {
				throw new IllegalArgumentException("Data già prenotata per questa postazione");
			}
		}

		int idPrenotazione = Math.abs(new Random().nextInt());

		Prenotazione prenotazione = new Prenotazione(idPrenotazione, dataPrenotazione, postazione, user);
		this.prenotazioni.add(prenotazione);

		return prenotazione;

	}

	public List<Prenotazione> getPrenotazione() {
		return this.prenotazioni;
	}

	public Optional<Prenotazione> findById(int id) {
		Prenotazione p = null;

		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.getId() == id)
				p = prenotazione;
		}
		return Optional.ofNullable(p);
	}
}
