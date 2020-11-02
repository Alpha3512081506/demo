package my.cinema.personel.cinema.sevices;

import my.cinema.personel.cinema.dao.*;
import my.cinema.personel.cinema.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
@Service
@Transactional
public class ICinemaImpl  implements ICinemaService{


    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ProjectionFilmRepository  projectionFilmRepository;
    @Autowired
    private SalleRepository salleRepository;
    private double[] coordone = {86.5,84,32.65,48.5,47.10,69.65,14.32,53};
    @Override
    public void initVille() {
        Stream.of("Cassino","Frosinone","Napoli","Roma","Milano","San Vittore del lazio","Casserta").forEach(nameVille->{
            Ville ville = new Ville();
            ville.setName(nameVille);
            ville.setLongitude(this.coordone[new Random().nextInt(this.coordone.length)]);
            ville.setAtitude(this.coordone[new Random().nextInt(this.coordone.length)]*1.2);
            ville.setLaltitude(this.coordone[new Random().nextInt(this.coordone.length)]*1.5);
            ville.setNombreDeCinema(3+ (int)(Math.random()*7));
            villeRepository.save(ville);


        });
    }

    @Override
    public void initCinema() {
        villeRepository.findAll().forEach(ville -> {

            for (int i = 1; i <= ville.getNombreDeCinema(); i++) {
                Cinema cinema = new Cinema();
                cinema.setName("cinema"+i);
                cinema.setVille(ville);
                cinema.setAtitude(this.coordone[new Random().nextInt(this.coordone.length)]*1.8);
                cinema.setLaltitude(this.coordone[new Random().nextInt(this.coordone.length)]*1.7);
                cinema.setLongitude(this.coordone[new Random().nextInt(this.coordone.length)]*1.6);
                cinema.setNombreDeSalle(3+(int)(Math.random()*5));
                cinemaRepository.save(cinema);


            }
        });

    }

    @Override
    public void initSalle() {
        cinemaRepository.findAll().forEach(cinema->{
            for (int i = 1; i < cinema.getNombreDeSalle(); i++) {
                Salle salle = new Salle();
                salle.setName("salle"+i);
                salle.setNombreDePlace(10+(int)(Math.random()*15));
               salle.setCinema(cinema);
                salleRepository.save(salle);

            }
        });

    }

    @Override
    public void initPlace() {
        salleRepository.findAll().forEach(salle->{
            for (int i = 1; i <= salle.getNombreDePlace() ; i++) {
                Place place = new Place();
                place.setNumero(i);
                place.setAltitude(this.coordone[new Random().nextInt(this.coordone.length)]*1.3);
                place.setLongitude(this.coordone[new Random().nextInt(this.coordone.length)]*1.2);
                place.setSalle(salle);
                placeRepository.save(place);

            }


        });

    }



    @Override
    public void initCategorie() {
        Stream.of("ACTION","FIXTION","DRAMA","HINDU","SERIE").forEach(categoriefilm->
        {
            Categorie categorie = new Categorie();
            categorie.setName(categoriefilm);
            categorieRepository.save(categorie);

        });

    }

    @Override
    public void initFilm() {
        Double duree[] = new Double[]{1.0,1.5,2.0,2.5,3.0,3.5,3.45};
        List<Categorie> categories = categorieRepository.findAll();
        Stream.of("Les Nuits de Cabiria","La Dolce Vita","Huit et demi ","Le Casanova de Fellini ","Ginger et Fred ","Roméo et Juliette","Jane Eyre","Rocco et ses frères ").forEach(titlefilm->{
            Film film = new Film();
            film.setTitle(titlefilm);
            film.setRealisateur("Marcello Mastroianni");
            film.setDateDeSortie(new Date());
            film.setDescription("Marcello Marcello MastroianniMastroianni");
            film.setDuree(duree[new Random().nextInt(duree.length)]);
            film.setPhoto(titlefilm.replaceAll(" ",""));
            film.setCategorie(categories.get(new Random().nextInt(categories.size())));
            filmRepository.save(film);

        });

    }

    @Override
    public void initSeance() {
        DateFormat df = new SimpleDateFormat("HH:mm");
        Stream.of("12:00","14:00","15:00","16:00","19:00").forEach(s->
        {
            Seance seance = new Seance();
            try {
                seance.setHeureDuDebut(df.parse(s));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            seanceRepository.save(seance);
        });

    }
    @Override
    public void initProjectionFilm() {
        villeRepository.findAll().forEach(ville->
        {
            ville.getCinemas().forEach(cinema->
            {
                cinema.getSalles().forEach(salle->
                {
                    filmRepository.findAll().forEach(film->
                    {
                        seanceRepository.findAll().forEach(seance ->
                        {
                            double[] price = new double[]{20.5,50,40,65,48,45,54} ;
                            ProjectionFilm projectionFilm = new ProjectionFilm();
                            projectionFilm.setDateDeProjection(new Date());
                            projectionFilm.setPrix(price[new Random().nextInt(price.length)]);
                            projectionFilm.setSeance(seance);
                            projectionFilm.setFilm(film);
                            projectionFilm.setSalle(salle);
                            projectionFilmRepository.save(projectionFilm) ;


                        });
                    });
                });
            });
        });

    }

    @Override
    public void initTicket() {
        projectionFilmRepository.findAll().forEach(p->
        {
            p.getSalle().getPlaces().forEach(place->{
                Ticket ticket = new Ticket();
                ticket.setProjectionFilm(p);
                ticket.setPrix(p.getPrix());
                ticket.setReserve(false);
                ticketRepository.save(ticket);
            });
        });

    }
}
