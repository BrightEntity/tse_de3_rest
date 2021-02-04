package tse.de3.applidistri.td;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;

    public void setEquipe(Equipe equipe) {
        if(this.equipe == equipe)
            return;

        this.equipe = equipe;
    }

    public void removeEquipe() {
        if(this.equipe == null)
            return;
        this.equipe = null;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="equipe_id")
    private Equipe equipe;


    protected Joueur() {}

    public Joueur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
