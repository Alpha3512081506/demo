package my.cinema.personel.cinema.dao;

import my.cinema.personel.cinema.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SalleRepository  extends JpaRepository<Salle,Long> {
}
