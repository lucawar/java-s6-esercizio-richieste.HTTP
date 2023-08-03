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
import lucaguerra.exceptions.BadRequestException;
import lucaguerra.exceptions.NotFoundException;
import lucaguerra.repositories.PrenotazioneRepository;

@Service
public class PrenotazioniService {

	@Autowired
	UsersService utenteService;

	@Autowired
	PostazioniService postazioneService;

	@Autowired
	PrenotazioneRepository prenotazioneRepository;

	// SALVA PRENOTAZIONE + ECCEZIONE SE VIENE PRENOTATA UNA POSTAZIONE GIA OCCUPATA
	// DA UNA DATA
	public Prenotazione save(NewPrenotazionePayload body) {
		int userId = body.getUserId();
		int postazioneId = body.getPostazioneId();
		LocalDate dataPrenotazione = body.getData();
		User user = utenteService.findById(userId);

		Postazione postazione = postazioneService.findById(postazioneId);

		int idPrenotazione = Math.abs(new Random().nextInt());
		Prenotazione Newprenotazione = new Prenotazione(idPrenotazione, dataPrenotazione, postazione, user);

		LocalDate dataMassimaPrenotazione = LocalDate.now().plusDays(2);
		if (dataPrenotazione.isBefore(dataMassimaPrenotazione)) {
			throw new BadRequestException("Non è stato possibile effettuare la prenotazione. "
					+ "La prenotazione deve essere effettuata almeno due giorni prima della data scelta.");
		}

		boolean prenotazionePostazioneEsistente = prenotazioneRepository
				.findByPostazioneIdAndDataPrenotazione(postazioneId, dataPrenotazione).isPresent();
		if (prenotazionePostazioneEsistente) {
			throw new BadRequestException("La postazione con ID: " + postazioneId
					+ " è già stata prenotata per la data: " + dataPrenotazione);
		}
		return prenotazioneRepository.save(Newprenotazione);

	}

	// TORNA LA LISTA DELLE PRENOTAZIONI
	public List<Prenotazione> getPrenotazione() {
		return prenotazioneRepository.findAll();
	}

	// CERCA PRENOTAZIONI TRAMITE ID
	public Prenotazione findById(int id) throws NotFoundException {
		return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	// MODIFICA PRENOTAZIONE TRAMITE ID
	public Prenotazione findByIdAndUpdate(int id, NewPrenotazionePayload body) throws NotFoundException {
		Prenotazione found = this.findById(id);
		found.setDataPrenotazione(body.getData());
		return prenotazioneRepository.save(found);
	}

	// CANCELLA PRENOTAZIONE TRAMITE ID
	public void findByIdAndDelete(int id) throws NotFoundException {
		Prenotazione found = this.findById(id);
		prenotazioneRepository.delete(found);
	}
}
