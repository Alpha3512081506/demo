package my.cinema.personel.cinema.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity @Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ProjectionFilm {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date dateDeProjection;
    private double prix;
    @ManyToOne
    private Film film;
    @ManyToOne
    private Salle salle;
    @OneToMany(mappedBy = "projectionFilm")
    private Collection<Ticket>  tickets;
    @ManyToOne
    private Seance seance;
}
