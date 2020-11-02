package my.cinema.personel.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Film {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75)
    private String title;
    @Column(length = 75)
    private double duree;
    @Column(length = 75)
    private String realisateur;
    @Column(length = 75)
    private String description;
    private String photo;
    private Date dateDeSortie;
    private int nombreDeFilm;
    @ManyToOne
    private Categorie categorie;
    @OneToMany(mappedBy = "film")
    private Collection<ProjectionFilm > projectionFilms;
}
