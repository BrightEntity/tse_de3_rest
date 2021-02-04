package tse.de3.applidistri.td;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(JoueurRepository repoJoueur, EquipeRepository equipeRepo) {
        return args -> {


            Joueur j1 = new Joueur("Baggins", "Bilbo");
            Joueur j2 = new Joueur("Baggins", "Frodo");
            Equipe equipe = new Equipe("PSG");
            equipe.addJoueur(j1);
            equipe.addJoueur(j2);

            log.info("Preloading " + repoJoueur.save(j1));
            log.info("Preloading " + repoJoueur.save(j2));


            log.info("Preloading " + equipeRepo.save(equipe));
        };
    }
}
