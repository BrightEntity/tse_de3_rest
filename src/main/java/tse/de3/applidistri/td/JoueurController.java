package tse.de3.applidistri.td;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoueurController {

    private JoueurRepository joueurRepository;

    @Autowired
    JoueurController(JoueurRepository joueurRepository) {
        this.joueurRepository = joueurRepository;
    }

    @GetMapping("/joueurs")
    public List<Joueur> all() {
        return this.joueurRepository.findAll();
    }

    @GetMapping("/joueur/{id}/equipe")
    public Equipe getEquipe(@PathVariable("id") Long id) {
        return this.joueurRepository.getOne(id).getEquipe();
    }

    @PostMapping("/joueur/{id}/equipe")
    public Joueur setEquipe(@PathVariable("id") Long id, @RequestBody Equipe equipe) {
        Joueur j = this.joueurRepository.getOne(id);
        j.setEquipe(equipe);
        return j;
    }
}
