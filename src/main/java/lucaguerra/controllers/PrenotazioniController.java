package lucaguerra.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

	@GetMapping("/infoItaliano")
	public String infoPrenotazioneIta() {
		return "Benvenuto nel sistema di prenotazioni, per poter prenotare una postazione abbiamo bisogno del tuo nome, cognome ed email. Inserisci una data per verificare la disponibilità";
	}

	@GetMapping("/infoInglese")
	public String infoPrenotazioneEng() {
		return "Welcome to the booking system, to book a spot we need your name, surname, and email. Enter a date to check availability.";
	}

	@GetMapping("/infoPrenotazione")
	public ResponseEntity<String> infoPrenotazione(@RequestParam(value = "lingua") String lingua) {

//		if (lingua == null) {
//			return ResponseEntity.badRequest().body("Inserisci una lingua tra italiano e inglese");
//		}

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
}
