package bo.edu.ucb.BackSoft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import bo.edu.ucb.BackSoft.bl.CustomerBl;
import bo.edu.ucb.BackSoft.bl.FilmActorBl;
import bo.edu.ucb.BackSoft.bl.FilmPaisBl;
import bo.edu.ucb.BackSoft.bl.FilmSearchUniqueBl;
import bo.edu.ucb.BackSoft.bl.FilmTitleBl;
import bo.edu.ucb.BackSoft.bl.PaymentBl;
import bo.edu.ucb.BackSoft.bl.RentalBl;
import bo.edu.ucb.BackSoft.dto.Actor;
import bo.edu.ucb.BackSoft.dto.Address;
import bo.edu.ucb.BackSoft.dto.Customer;
import bo.edu.ucb.BackSoft.dto.Film;
import bo.edu.ucb.BackSoft.dto.Payment;
import bo.edu.ucb.BackSoft.dto.Rental;

@RestController()
public class Sakilapi {

    FilmTitleBl filmTitleBl;
    FilmActorBl filmActorBl;
    FilmSearchUniqueBl filmSearchUniqueBl;
    FilmPaisBl filmPaisBl;
    RentalBl rentalBl;
    CustomerBl customerBl;
    PaymentBl paymentBl;

    @Autowired
    public Sakilapi(FilmTitleBl filmTitleBl, FilmActorBl filmActorBl, FilmSearchUniqueBl filmSearchUniqueBl,
            FilmPaisBl filmPaisBl, RentalBl rentalBl, CustomerBl customerBl, PaymentBl paymentBl) {
        this.filmTitleBl = filmTitleBl;
        this.filmActorBl = filmActorBl;
        this.filmSearchUniqueBl = filmSearchUniqueBl;
        this.filmPaisBl = filmPaisBl;
        this.rentalBl = rentalBl;
        this.customerBl = customerBl;
        this.paymentBl = paymentBl;

    }

    // titulo***
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(value = "/film/{id}/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findBytTitle(@PathVariable(name = "id") Integer id, @PathVariable(name = "title") String title) {
        return filmTitleBl.findByTitle(id, title);
    }

    // Actor nombre y apellido***
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(value = "/actor/{id}/{actorn}/{actorl}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Actor> findByActor(@PathVariable(name = "id") Integer id, @PathVariable(name = "actorn") String actorn,
            @PathVariable(name = "actorl") String actorl) {
        return filmActorBl.findByActor(id, actorn, actorl);
    }

    // Busqueda de pelicula por store*******
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(value = "/storeU/{stid}/{fid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findByFilmUnique(@PathVariable(name = "stid") Integer stid,
            @PathVariable(name = "fid") Integer fid) {
        return filmSearchUniqueBl.findByFilmUnique(stid, fid);
    }

    // Pelicilas por store 1 o 2***
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(value = "/store/{stid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findByFilmCountry(@PathVariable(name = "stid") Integer stid) {
        return filmPaisBl.findByFilmCountry(stid);
    }

    // Peliculas por estreno y viendo store******
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(value = "/filmE/store/{stid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findByEstrenos(@PathVariable(name = "stid") Integer stid) {
        return filmPaisBl.findByEstrenos(stid);
    }

    // Peliculas de la semana****
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(value = "/filmS/store/{stid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findByWeek(@PathVariable(name = "stid") Integer stid) {
        return filmPaisBl.findByWeek(stid);
    }

    // Peliculas de siempre*****
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(value = "/filmA/store/{stid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Film> findBySiempre(@PathVariable(name = "stid") Integer stid) {
        return filmPaisBl.findBySiempre(stid);
    }

    // Create rental
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping(value = "/rental", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public String createRental(@RequestBody Rental rental) {
        return rentalBl.createRental(rental);

    }

    // Create customer
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createCustomer(@RequestBody Customer customer) {
        return customerBl.createCustomer(customer);

    }

    // Create payment
    
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping(value = "/payment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createPayment(@RequestBody Payment payment) {
        return paymentBl.createPayment(payment);

    } 

    
    

   

}