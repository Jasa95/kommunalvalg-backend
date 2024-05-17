package examen.kommunalvalgbackend;

import examen.kommunalvalgbackend.entity.Candidate;
import examen.kommunalvalgbackend.entity.Party;
import examen.kommunalvalgbackend.repository.CandidateRepository;
import examen.kommunalvalgbackend.repository.PartyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KommunalvalgBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(KommunalvalgBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner importdata(PartyRepository partyRepository, CandidateRepository candidateRepository) {
        return (args) -> {
            // import data here
            Party p1 = new Party();
            p1.setName("A");
            partyRepository.save(p1);

            Party p2 = new Party();
            p2.setName("B");
            partyRepository.save(p2);

            Candidate c1 = new Candidate();
            c1.setName("C1");
            c1.setParty(p1);
            candidateRepository.save(c1);

            Candidate c2 = new Candidate();
            c2.setName("C2");
            c2.setParty(p2);
            candidateRepository.save(c2);

            Candidate c3 = new Candidate();
            c3.setName("C3");
            c3.setParty(p2);
            candidateRepository.save(c3);

            Candidate c4 = new Candidate();
            c4.setName("C4");
            c4.setParty(p1);
            candidateRepository.save(c4);


        };
    }
}
