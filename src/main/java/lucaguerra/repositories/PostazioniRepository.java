package lucaguerra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lucaguerra.entities.Postazione;

public interface PostazioniRepository extends JpaRepository<Postazione, Integer> {

	Optional<Postazione> findByDisponibilita(boolean disponibilita);

}
