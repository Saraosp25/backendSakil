package bo.edu.ucb.BackSoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dto.Actor;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class ActorDao {

    private DataSource dataSource;

    @Autowired
    public ActorDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Actor> findByActor(Integer id,String actorn, String actorl) {
        List<Actor> result = new ArrayList<>();
        String query = "SELECT DISTINCT a.actor_id"+
        ",a.first_name"+
        ",a.last_name"+
        ",f.film_id"+
        ",f.title"+
       " ,f.description"+
       ", f.length"+
       ", l.name as language"+
       ",ol.name as original_language" +
       " FROM  actor a" +
       " LEFT JOIN film_actor fa ON (a.actor_id = fa.actor_id)" +
       " LEFT JOIN film f ON (fa.film_id = f.film_id)" 
       + " LEFT JOIN language l ON ( f.language_id = l.language_id) "
       + " LEFT JOIN language ol ON ( f.original_language_id = ol.language_id) "
       + "  left join inventory i on (i.film_id=f.film_id)"
       + " left join rental r on (r.inventory_id=i.inventory_id) "
       + " left join store s on (s.store_id=i.store_id)" + "left join address ad on (ad.address_id=s.address_id) "
       + " left join city cy on (cy.city_id=ad.city_id) "
       + " left join country cc on(cc.country_id=cy.country_id) "
       + " left join film_category fc on (fc.film_id=f.film_id) "
       + " left join category c on(c.category_id=fc.category_id) " + " where s.store_id=(?) "+
      "  and UPPER( a.first_name) LIKE (?) AND UPPER(a.last_name) LIKE (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
            System.out.println(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, "%"+actorn.toUpperCase()+ "%");
            pstmt.setString(3, "%"+actorl.toUpperCase()+ "%");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Actor actor= new Actor();
                actor.setFilmId(rs.getInt("film_id"));
                actor.setTitle(rs.getString("title"));
                actor.setDescription(rs.getString("description"));
                actor.setLanguage("language");
                actor.setOriginalLanguage("original_language");
                actor.setLength(rs.getInt("length"));
                //Actor
                actor.setActorId(rs.getInt("actor_id"));
                actor.setName(rs.getString("first_name"));
                actor.setLast(rs.getString("last_name"));
               
            
                result.add(actor);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return result;
    }
}
