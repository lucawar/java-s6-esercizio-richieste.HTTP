package lucaguerra.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lucaguerra.ENUM.TipoPostazione;
import lucaguerra.entities.Postazione;

public interface PostazioniRepository extends JpaRepository<Postazione, Integer> {

	Optional<Postazione> findByCittaAndTipoPostazione(String citta, TipoPostazione tipoPostazione);
}
