package lucaguerra.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import lucaguerra.entities.Postazione;

@Service
public class PostazioniService {

	private List<Postazione> postazioni = new ArrayList<>();

	public Postazione save(Postazione postazione) {
		Random rndm = new Random();
		postazione.setId(rndm.nextInt());
		this.postazioni.add(postazione);
		return postazione;
	}

	public List<Postazione> getPostazioni() {
		return this.postazioni;
	}

	public Optional<Postazione> findById(int id) {
		Postazione p = null;

		for (Postazione postazione : postazioni) {
			if (postazione.getId() == id)
				p = postazione;
		}
		return Optional.ofNullable(p);
	}
}
