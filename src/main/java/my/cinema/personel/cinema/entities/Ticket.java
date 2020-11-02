package my.cinema.personel.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(length = 75)
    private String clientName;
    private double prix;
    private int codeDepaiement;
    private Boolean reserve;
    @ManyToOne
    private ProjectionFilm projectionFilm;
}
