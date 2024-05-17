package examen.kommunalvalgbackend.service;

import examen.kommunalvalgbackend.entity.Candidate;
import examen.kommunalvalgbackend.entity.Party;
import examen.kommunalvalgbackend.repository.CandidateRepository;
import examen.kommunalvalgbackend.repository.PartyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service

public class PartyService {
    private final PartyRepository partyRepository;
    private final CandidateRepository candidateRepository;

    public PartyService(PartyRepository partyRepository, CandidateRepository candidateRepository) {
        this.partyRepository = partyRepository;
        this.candidateRepository = candidateRepository;
    }

    public List<Party> getParties() {
        return partyRepository.findAll();
    }

    public Party getPartyById(int id) {
        return partyRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Party not found"));
    }

    public Party addCandidateToParty(int partyId, Candidate candidate) {
        // Find party by id or throw exception
        Party party = partyRepository.findById(partyId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Party not found"));
        // Get all candidates from party
        List<Candidate> oldCandidates = party.getCandidates();
        // Create new candidate to save in party
        Candidate newCandidate = new Candidate();
        // Set new candidate name
        newCandidate.setName(candidate.getName());
        // Set new candidate party
        newCandidate.setParty(party);
        // Save new candidate
        candidateRepository.save(newCandidate);
        // Add new candidate to old candidates
        oldCandidates.add(newCandidate);
        // Set old candidates to party
        party.setCandidates(oldCandidates);
        // Save party
        return partyRepository.save(party);
    }
}
