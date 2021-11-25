package bo.edu.ucb.BackSoft.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dao.ActorDao;
import bo.edu.ucb.BackSoft.dto.Actor;
import bo.edu.ucb.BackSoft.exception.SakilaException;
@Component
public class FilmActorBl {
    private final ActorDao actorDao;

    @Autowired
    public FilmActorBl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    public List<Actor> findByActor(Integer id ,String actorn,String actorl) {
        if (id==null||actorn == null || actorn.trim().equals("")||actorl == null || actorl.trim().equals("")) {
            throw new SakilaException(403, "Bad request: The actor parameter is mandatory and can't be null or empty");
        }
        return actorDao.findByActor(id,actorn,actorl);
    }
}
