package my.cinema.personel.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Ville {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int nombreDeCinema;
    private double longitude;
    private double laltitude;
    private double atitude;
    @OneToMany(mappedBy = "ville")
    private Collection<Cinema>  cinemas;
}
