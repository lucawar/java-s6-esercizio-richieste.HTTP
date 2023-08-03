package lucaguerra.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lucaguerra.ENUM.TipoPostazione;
import lucaguerra.entities.NewPostazionePayload;
import lucaguerra.entities.Postazione;
import lucaguerra.services.PostazioniService;

@RestController
@RequestMapping("/postazioni")
public class PostazioniController {

	@Autowired
	PostazioniService postazioneService;

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Postazione savePostazione(@RequestBody NewPostazionePayload body) {
		Postazione createdPostazione = postazioneService.save(body);
		return createdPostazione;
	}

	@GetMapping("")
	public List<Postazione> getPostazioni() {
		return postazioneService.getPostazioni();
	}

	@GetMapping("/{postazioneId}")
	public Postazione findById(@PathVariable int postazioneId) {
		return postazioneService.findById(postazioneId);
	}

	@PutMapping("/{postazioneId}")
	public Postazione updatePostazione(@PathVariable int postazioneId, @RequestBody NewPostazionePayload body) {
		return postazioneService.findByIdAndUpdate(postazioneId, body);
	}

	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePostazione(@PathVariable int postazioneId) {
		postazioneService.findByIdAndDelete(postazioneId);
	}

	@GetMapping("/cerca")
	public ResponseEntity<Postazione> findByCittaAndTipoPostazione(@RequestParam(value = "citta") String citta,
			@RequestParam(value = "TipoPostazione") TipoPostazione tipoPostazione) {
		Optional<Postazione> postazioneOptional = postazioneService.findByCittaAndTipoPostazione(citta, tipoPostazione);

		return postazioneOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
