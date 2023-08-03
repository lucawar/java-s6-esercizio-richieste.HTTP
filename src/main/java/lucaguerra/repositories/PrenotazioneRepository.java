package lucaguerra.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucaguerra.entities.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

	// QUERY PER NON PRENOTARE UNA POSTAZIONE CON UNA DATA GIA OCCUPATA
	Optional<Prenotazione> findByPostazioneIdAndDataPrenotazione(int postazioneId, LocalDate dataPrenotazione);

}
