package tse.de3.applidistri.td;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/equipe")
    public Equipe addTeam(Equipe equipe) {
        return this.equipeRepository.save(equipe);
    }
}
