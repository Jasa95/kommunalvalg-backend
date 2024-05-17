package examen.kommunalvalgbackend.api;

import examen.kommunalvalgbackend.entity.Candidate;
import examen.kommunalvalgbackend.entity.Party;
import examen.kommunalvalgbackend.service.PartyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parties")

public class PartyController {
    private final PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping
    public List<Party> getParties() {
        return partyService.getParties();
    }

    @GetMapping("/{id}")
    public Party getPartyById(@PathVariable int id) {
        return partyService.getPartyById(id);
    }

    @PostMapping("/{partyId}/add-candidate")
    public Party addCandidateToParty(@PathVariable int partyId, @RequestBody Candidate candidate) {
        return partyService.addCandidateToParty(partyId, candidate);
    }

}
