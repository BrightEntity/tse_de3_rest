package tse.de3.applidistri.td;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Equipe {

    public Equipe() {

    }
    public Equipe(String nom) {
        this.nom = nom;
        this.joueurs = new HashSet<Joueur>();
    }
    public Equipe(String nom, HashSet<Joueur> joueurs) {
        this.nom = nom;
        this.joueurs = joueurs;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "joueur_id")
    private Set<Joueur> joueurs;

    public String getNom() {
        return nom;
    }

    public Set<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Set<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void addJoueur(Joueur joueur) {

        // On empêche une boucle infinie
        if(this.joueurs.contains(joueur))
            return;

        this.getJoueurs().add(joueur);
        joueur.setEquipe(this);
    }

    public void removeJoueur(Joueur joueur) {
        if(!this.joueurs.contains(joueur))
            return;

        this.joueurs.remove(joueur);
        joueur.removeEquipe();
    }

    @Override
    public String toString() {
        return "Equipe " + nom;
    }
}
