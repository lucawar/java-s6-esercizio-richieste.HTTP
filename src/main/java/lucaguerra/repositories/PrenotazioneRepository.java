package lucaguerra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucaguerra.entities.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {

}
