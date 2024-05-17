package examen.kommunalvalgbackend.repository;

import examen.kommunalvalgbackend.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Integer> {
}
