package examen.kommunalvalgbackend.repository;

import examen.kommunalvalgbackend.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
