package my.cinema.personel.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
//@Table(name = "CINEMA")
public class Cinema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "NAME")
    private String name;
    @JsonIgnore
    //@Column(name = "LONGITUDE")
    private double longitude;
    @JsonIgnore
    //@Column(name = "LATITUDE")
    private double laltitude ;
    @JsonIgnore
    //@Column(name="ATITUDE")
    private double atitude;
   // @Column(name = "NOMBREDESALLE")
    private int nombreDeSalle;
    @ManyToOne
    private Ville ville;
    @OneToMany(mappedBy = "cinema")
    private Collection<Salle>  salles;
}
