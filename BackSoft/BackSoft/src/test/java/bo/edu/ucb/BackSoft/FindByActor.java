package bo.edu.ucb.BackSoft;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bo.edu.ucb.BackSoft.bl.FilmActorBl;
import bo.edu.ucb.BackSoft.dto.Actor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class FindByActorTest {

	@Autowired
	FilmActorBl filmActorBl;

	@Test
	void findExactlyOne() {
		// Buscamos la pelicula
		List<Actor> actors = filmActorBl.findByActor(2,"Ed","Chase");
		// Probamos que el resultado sea el epserado
		assertNotNull(actors, "La busqueda retorno una lista nula");
		Actor actor = actors.get(0);
        assertEquals("ED", actor.getName(), "No encontramos a un actor con ese nombre");
        assertEquals("CHASE", actor.getLast(), "No encontramos a un actor con ese apellido");
		assertEquals("ALONE TRIP", actor.getTitle(), "El titulo de la película no coincide");
		assertTrue( actor.getDescription().startsWith("A Fast-Paced Character Study of a Composer And a Dog who must Outgun a Boat in An Abandoned Fun House"), "La descripcion de la película no coincide");
		assertEquals("1h 22m", actor.getLengthLabel(), "La hora no coincide o esta en formato incorrecto");
	}

}
