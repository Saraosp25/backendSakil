package bo.edu.ucb.BackSoft.bl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dao.FilmUniqueDao;
import bo.edu.ucb.BackSoft.dto.Film;
import bo.edu.ucb.BackSoft.exception.SakilaException;


@Component
public class FilmSearchUniqueBl {
    private final FilmUniqueDao filmUniqueDao;


    @Autowired
    public FilmSearchUniqueBl(FilmUniqueDao filmUniqueDao) {
        this.filmUniqueDao = filmUniqueDao;
    }

    public List<Film> findByFilmUnique(Integer filmid,Integer storeid) {
        if (filmid == null ||storeid == null ) {
            throw new SakilaException(403, "Bad request: The actor parameter is mandatory and can't be null or empty");
        }
        return filmUniqueDao.findByFilmUnique(filmid,storeid);
    }
    
}
