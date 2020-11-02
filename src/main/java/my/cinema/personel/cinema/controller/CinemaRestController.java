package my.cinema.personel.cinema.controller;

import my.cinema.personel.cinema.dao.FilmRepository;
import my.cinema.personel.cinema.entities.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaRestController {
    @Autowired
    private FilmRepository filmRepository ;
    @GetMapping(value = "images/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] images(@PathVariable(name = "id")Long id)
    {

       return  null ;
    }
}
