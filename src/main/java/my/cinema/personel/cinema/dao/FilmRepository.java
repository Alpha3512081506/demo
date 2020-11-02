package my.cinema.personel.cinema.dao;

import my.cinema.personel.cinema.entities.Categorie;
import my.cinema.personel.cinema.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film,Long> {
}
