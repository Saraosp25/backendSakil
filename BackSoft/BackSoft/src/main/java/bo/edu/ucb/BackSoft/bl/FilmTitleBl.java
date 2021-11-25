package bo.edu.ucb.BackSoft.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dao.TitleDao;
import bo.edu.ucb.BackSoft.dto.Film;
import bo.edu.ucb.BackSoft.exception.SakilaException;
@Component
public class FilmTitleBl {
    private final TitleDao titleDao;

    

    @Autowired
    public FilmTitleBl( TitleDao titleDao) {
        this.titleDao = titleDao;
    }
    
   
    public List<Film> findByTitle(Integer id,String title) {
        if (id == null ||title == null || title.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The title parameter is mandatory and can't be null or empty");
        }
        return titleDao.findByTitle(id,title);
    }
}
