package bo.edu.ucb.BackSoft.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dto.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Component
public class FilmUniqueDao{

    private DataSource dataSource;

    @Autowired
    public FilmUniqueDao (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Film> findByFilmUnique(Integer fid,Integer stoid) {
        List<Film> result = new ArrayList<>();
        String query = "SELECT DISTINCT f.film_id ,f.title,f.description,c.country,f.release_year,f.rating,f.special_features"+ 
       "  FROM film f,actor a,country c,city cc,address aa, store s,inventory i"+
       "  WHERE s.store_id=i.store_id"+
       "  and c.country_id=cc.country_id"+
       "  and cc.city_id=aa.city_id"+
       "  and aa.address_id=s.address_id"+
        " and s.store_id=(?) and f.film_id=(?)" ;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
            System.out.println(query);
            pstmt.setInt(1, stoid);
            pstmt.setInt(2, fid);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setCountry(rs.getString("country"));
                film.setReleaseYear(rs.getShort("release_year"));
                film.setRating(rs.getString("rating"));
                film.setSpecialFeatures(rs.getString("special_features"));
               
                result.add(film);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return result;
    }






}