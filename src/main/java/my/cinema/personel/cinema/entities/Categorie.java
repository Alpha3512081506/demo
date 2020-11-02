package my.cinema.personel.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity @Data@NoArgsConstructor @AllArgsConstructor
public class  Categorie {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="NAME",length = 75)
    private String name;
    @OneToMany(mappedBy = "categorie")
    private Collection<Film > films;
}
