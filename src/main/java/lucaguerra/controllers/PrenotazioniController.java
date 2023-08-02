package lucaguerra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lucaguerra.entities.NewPrenotazionePayload;
import lucaguerra.entities.Prenotazione;
import lucaguerra.services.PrenotazioniService;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

	@Autowired
	PrenotazioniService prenotazioneService;

	@GetMapping("/infoPrenotazione")
	public ResponseEntity<String> infoPrenotazione(@RequestParam(value = "lingua") String lingua) {

		String messaggio;
		if (lingua.equalsIgnoreCase("italiano")) {
			messaggio = "Benvenuto nel sistema di prenotazioni, per poter prenotare una postazione abbiamo bisogno del tuo nome, cognome ed email. Inserisci una data per verificare la disponibilità";
		} else if (lingua.equalsIgnoreCase("inglese")) {
			messaggio = "Welcome to the booking system, to book a spot we need your name, surname, and email. Enter a date to check availability.";
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lingua selezionata non è disponibile");
		}
		return ResponseEntity.ok(messaggio);
	}

	@PostMapping("")
	public ResponseEntity<Prenotazione> save(@RequestBody NewPrenotazionePayload body) {
		Prenotazione prenotazione = prenotazioneService.save(body);
		return ResponseEntity.status(HttpStatus.CREATED).body(prenotazione);

	}

	@GetMapping("")
	public List<Prenotazione> getPrenotazione() {
		return prenotazioneService.getPrenotazione();
	}

//	@GetMapping("/{prenotazioneId}")
//	public Prenotazione findById(@PathVariable int userId) throws Exception {
//		return prenotazioneService.findById(userId).orElseThrow(() -> new Exception("PRENOTAZIONE NON TROVATA"));
//	}
}
