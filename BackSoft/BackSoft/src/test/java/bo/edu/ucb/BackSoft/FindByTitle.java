package bo.edu.ucb.BackSoft;
import java.util.List;
import bo.edu.ucb.BackSoft.bl.FilmTitleBl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import bo.edu.ucb.BackSoft.dto.Film;

@SpringBootTest
class FindByTitle {

	@Autowired
	FilmTitleBl filmTitleBl;

	@Test
	void findExactlyOne() {
		// Buscamos la pelicula
		List<Film> films = filmTitleBl.findByTitle(1,"maude");
		// Probamos que el resultado sea el epserado
		assertNotNull(films, "La busqueda retorno una lista nula");
		assertEquals(1, films.size(), "La busqueda debería retornar exactamente un elemento");
		Film film = films.get(0);
		assertEquals("MAUDE MOD", film.getTitle(), "El titulo de la película no coincide");
		assertTrue( film.getDescription().startsWith("A Beautiful Documentary of a Forensic"), "La descripcion de la película no coincide");
		assertEquals("1h 12m", film.getLengthLabel(), "La hora no coincide o esta en formato incorrecto");
	}

}