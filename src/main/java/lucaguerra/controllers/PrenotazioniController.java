package lucaguerra.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioniController {

	@GetMapping("/infoItaliano")
	public String infoPrenotazione() {
		return "Benvenuto nel sistema di prenotazioni, per poter prenotare una postazione abbiamo bisogno del tuo nome, cognome ed email. Inserisci una data per verificare la disponibilità";
	}
}
