package lucaguerra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lucaguerra.entities.Postazione;
import lucaguerra.services.PostazioniService;

@RestController
@RequestMapping("/postazioni")
public class PostazioniController {

	@Autowired
	PostazioniService postazioneService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione saveUser(@RequestBody Postazione body) {
		Postazione createdPostazione = postazioneService.save(body);
		return createdPostazione;
	}

	@GetMapping("")
	public List<Postazione> getPostazioni() {
		return postazioneService.getPostazioni();
	}

	@GetMapping("/{postazioneId}")
	public Postazione findById(@PathVariable int userId) throws Exception {
		return postazioneService.findById(userId).orElseThrow(() -> new Exception("POSTAZIONE NON TROVATA"));
	}

	@GetMapping("/cerca")
	public List<Postazione> searchPostazioniByTipoAndCitta(
			@RequestParam(value = "tipoPostazione") String tipoPostazione,
			@RequestParam(value = "citta") String citta) {
		return postazioneService.searchByTipoandCitta(tipoPostazione, citta);
	}
}
