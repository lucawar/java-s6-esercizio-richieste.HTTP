package lucaguerra.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucaguerra.entities.NewPostazionePayload;
import lucaguerra.entities.Postazione;
import lucaguerra.exceptions.BadRequestException;
import lucaguerra.exceptions.NotFoundException;
import lucaguerra.repositories.PostazioniRepository;

@Service
public class PostazioniService {

//	private List<Postazione> postazioni = new ArrayList<>();

	@Autowired
	PostazioniRepository postazioniRepository;

	public Postazione save(NewPostazionePayload body) {
		boolean disponibilita = body.isDisponibilita();
		boolean postazioneDisp = postazioniRepository.findByDisponibilita(disponibilita).isPresent();
		if (postazioneDisp) {
			throw new BadRequestException("Una postazione con disponibilità " + disponibilita + " è già presente");
		}
		Postazione newPostazione = new Postazione(body.getDescrizione(), body.getNumerMaxOccupanti(),
				body.isDisponibilita(), body.getTipoPostazione(), body.getCitta());
		return postazioniRepository.save(newPostazione);
	}

	// TORNA LA LISTA DELLE POSTAZIONI
	public List<Postazione> getPostazioni() {
		return postazioniRepository.findAll();
	}

	// CERCA UTENTE TRAMITE ID
	public Postazione findById(int id) throws NotFoundException {
		return postazioniRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

//	public Optional<Postazione> searchByTipoAndCitta(String tipoPostazione, String citta) {
//		TipoPostazione tipoPostazioneEnum = TipoPostazione.valueOf(tipoPostazione);
//		return postazioniRepository.findByTipoPostazioneAndCitta(tipoPostazioneEnum, citta);
//	}
}
