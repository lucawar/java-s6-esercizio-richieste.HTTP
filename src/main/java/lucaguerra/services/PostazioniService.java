package lucaguerra.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucaguerra.ENUM.TipoPostazione;
import lucaguerra.entities.NewPostazionePayload;
import lucaguerra.entities.Postazione;
import lucaguerra.exceptions.NotFoundException;
import lucaguerra.repositories.PostazioniRepository;

@Service
public class PostazioniService {

	@Autowired
	PostazioniRepository postazioniRepository;

	// SALVA POSTAZIONE
	public Postazione save(NewPostazionePayload body) {
		Postazione newPostazione = new Postazione(body.getDescrizione(), body.getNumerMaxOccupanti(),
				body.getTipoPostazione(), body.getCitta());
		return postazioniRepository.save(newPostazione);
	}

	// TORNA LA LISTA DELLE POSTAZIONI
	public List<Postazione> getPostazioni() {
		return postazioniRepository.findAll();
	}

	// CERCA POSTAZIONE TRAMITE ID
	public Postazione findById(int id) throws NotFoundException {
		return postazioniRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	// CERCA POSTAZIONE TRAMITE ID E MODIFICA
	public Postazione findByIdAndUpdate(int id, NewPostazionePayload body) throws NotFoundException {
		Postazione found = this.findById(id);
		found.setDescrizione(body.getDescrizione());
		found.setNumerMaxOccupanti(body.getNumerMaxOccupanti());
		found.setDescrizione(body.getDescrizione());
		found.setCitta(body.getCitta());
		return postazioniRepository.save(found);
	}

	// CANCELLA POSTAZIONE TRAMITE ID
	public void findByIdAndDelete(int id) throws NotFoundException {
		Postazione found = this.findById(id);
		postazioniRepository.delete(found);

	}

	// CERCA POSTAZIONE TRAMITE CITTA E TIPO POSTAZIONE
	public Optional<Postazione> findByCittaAndTipoPostazione(String citta, TipoPostazione tipoPostazione) {
		return postazioniRepository.findByCittaAndTipoPostazione(citta, tipoPostazione);
	}

}
