package lucaguerra.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucaguerra.entities.NewPrenotazionePayload;
import lucaguerra.entities.Postazione;
import lucaguerra.entities.Prenotazione;
import lucaguerra.entities.User;
import lucaguerra.repositories.PrenotazioneRepository;

@Service
public class PrenotazioniService {
//orElseThrow(() -> new IllegalArgumentException(userId + " Utente non trovato"));

	@Autowired
	UsersService utenteService;

	@Autowired
	PostazioniService postazioneService;

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	public Prenotazione save(NewPrenotazionePayload body) {

		int userId = body.getUserId();
		int postazioneId = body.getPostazioneId();
		LocalDate dataPrenotazione = body.getData();
		User user = utenteService.findById(userId);

		Postazione postazione = postazioneService.findById(postazioneId);

//		for (Prenotazione prenotazione : prenotazioni) {
//			if (prenotazione.getDataPrenotazione().equals(dataPrenotazione)) {
//				throw new IllegalArgumentException("Data già prenotata per questa postazione");
//			}
//		}

		int idPrenotazione = Math.abs(new Random().nextInt());
		Prenotazione Newprenotazione = new Prenotazione(idPrenotazione, dataPrenotazione, postazione, user);

		return prenotazioneRepository.save(Newprenotazione);

	}

	// TORNA LA LISTA DEGLI UTENTI
	public List<Prenotazione> getPrenotazione() {
		return prenotazioneRepository.findAll();
	}

//	public Optional<Prenotazione> findById(int id) {
//		Prenotazione p = null;
//
//		for (Prenotazione prenotazione : prenotazioni) {
//			if (prenotazione.getId() == id)
//				p = prenotazione;
//		}
//		return Optional.ofNullable(p);
//	}
}
