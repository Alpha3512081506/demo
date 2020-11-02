package my.cinema.personel.cinema;

import my.cinema.personel.cinema.sevices.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {
    @Autowired
    private ICinemaService cinemaService;

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cinemaService.initVille();
        cinemaService.initCinema();
        cinemaService.initSalle();
        cinemaService.initPlace();
        cinemaService.initCategorie();
        cinemaService.initFilm();
        cinemaService.initSeance();
        cinemaService.initProjectionFilm();
         cinemaService.initTicket();


    }
}
