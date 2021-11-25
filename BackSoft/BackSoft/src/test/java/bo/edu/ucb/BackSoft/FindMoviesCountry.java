package bo.edu.ucb.BackSoft;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bo.edu.ucb.BackSoft.bl.FilmPaisBl;
import bo.edu.ucb.BackSoft.dto.Customer;
import bo.edu.ucb.BackSoft.dto.Film;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

@SpringBootTest
class findByFilmsCountry {

	@Autowired
	FilmPaisBl filmPaisBl;

	@Test
	void findSiempre() {

		List<Film> films = filmPaisBl.findBySiempre(2);
		// Probamos que el resultado sea el epserado
		assertNotNull(films, "La busqueda retorno una lista nula");
		Film film = films.get(0);
		assertEquals("AIRPORT POLLOCK", film.getTitle(), "El titulo de la película no coincide");
		assertTrue( film.getDescription().startsWith("A Epic Tale of a Moose And a Girl who must Confront a Monkey in Ancient India"), "La descripcion de la película no coincide");
		

		
	}

	
	@Test
	void findestrenos() {

		List<Film> films = filmPaisBl.findByEstrenos(2);
		// Probamos que el resultado sea el epserado
		assertNotNull(films, "La busqueda retorno una lista nula");
		Film film = films.get(0);
		assertEquals("ZORRO ARK", film.getTitle(), "El titulo de la película no coincide");
		assertTrue( film.getDescription().startsWith("A Intrepid Panorama of a Mad Scientist And a Boy who must Redeem a Boy in A Monastery"), "La descripcion de la película no coincide");
		

		
	}

	@Test
	void findSemana() {

		List<Film> films = filmPaisBl.findByWeek(2);
		// Probamos que el resultado sea el epserado
		assertNotNull(films, "La busqueda retorno una lista nula");
		Film film = films.get(0);
		assertEquals("AFFAIR PREJUDICE", film.getTitle(), "El titulo de la película no coincide");
		assertTrue( film.getDescription().startsWith("A Fanciful Documentary of a Frisbee And a Lumberjack who must Chase a Monkey in A Shark Tank"), "La descripcion de la película no coincide");
		

		
	}

	

}