package bo.edu.ucb.BackSoft.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dao.FilmPaisDao;
import bo.edu.ucb.BackSoft.dto.Film;
import bo.edu.ucb.BackSoft.exception.SakilaException;



@Component
public class FilmPaisBl {

    private final FilmPaisDao filmPaisDao;

    @Autowired
    public FilmPaisBl(FilmPaisDao filmPaisDao) {
        this.filmPaisDao = filmPaisDao;
    }

    public List<Film> findByFilmCountry(Integer country) {
        if (country == null) {
            throw new SakilaException(403, "Bad request: The country parameter is mandatory and can't be null or empty");
        }
        return filmPaisDao.findByFilmCountry(country);
    }

   

    public List<Film> findByEstrenos(Integer country) {
        if (country == null) {
            throw new SakilaException(403, "Bad request: The country parameter is mandatory and can't be null or empty");
        }
        return filmPaisDao.findByEstrenos(country);
    }

    public List<Film> findByWeek(Integer country) {
        if (country == null) {
            throw new SakilaException(403, "Bad request: The country parameter is mandatory and can't be null or empty");
        }
        return filmPaisDao.findByWeek(country);
    }

    public List<Film> findBySiempre(int country) {
        if (country == 0) {
            throw new SakilaException(403, "Bad request: The country parameter is mandatory and can't be null or empty");
        }
        return filmPaisDao.findBySiempre(country);
    }
}

   

