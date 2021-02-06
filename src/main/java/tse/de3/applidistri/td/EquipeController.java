package tse.de3.applidistri.td;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipeController {
    EquipeRepository equipeRepository;

    @Autowired
    EquipeController(EquipeRepository repo) {
        this.equipeRepository = repo;
    }

    @GetMapping("/equipes")
    public List<Equipe> all() {
        return this.equipeRepository.findAll();
    }

    @GetMapping("/equipe/{id}")
    public Equipe get(@PathVariable Long id) {
        return this.equipeRepository.getOne(id);
    }

    @RequestMapping(value = "/equipe", method = RequestMethod.PUT)
    public Equipe addTeam(@ModelAttribute Equipe equipe) {
        Equipe eq = new Equipe();
        eq.setNom(equipe.getNom());
        eq.setJoueurs(equipe.getJoueurs());
        this.equipeRepository.save(eq);
        return eq;
    }

    @RequestMapping(value = "/equipe", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Equipe updateEquipe(@RequestBody Equipe equipe) {
        Equipe eq = this.equipeRepository.getOne(equipe.getId());
        eq.setNom(equipe.getNom());
        eq.setJoueurs(equipe.getJoueurs());
        this.equipeRepository.save(eq);
        return eq;
    }
}
