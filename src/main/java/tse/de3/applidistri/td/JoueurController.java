package tse.de3.applidistri.td;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
