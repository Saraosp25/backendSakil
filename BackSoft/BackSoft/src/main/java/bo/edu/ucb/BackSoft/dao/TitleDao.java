package bo.edu.ucb.BackSoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dto.Film;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TitleDao {
    private DataSource dataSource;

    @Autowired
    public TitleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Film> findByTitle(Integer id, String title) {
        List<Film> result = new ArrayList<>();
        String query = "SELECT DISTINCT f.film_id, " + "   f.title, " + "   f.description, " + "   f.release_year, "
                + " l.name as language , " + "   ol.name as original_language, " + "   f.length, " + "   f.rating, "
                + " f.special_features, " + "   f.last_update " + " FROM film f "
                + " LEFT JOIN language l ON ( f.language_id = l.language_id) "
                + " LEFT JOIN language ol ON ( f.original_language_id = ol.language_id) "
                + "  left join inventory i on (i.film_id=f.film_id)"
                + " left join rental r on (r.inventory_id=i.inventory_id) "
                + " left join store s on (s.store_id=i.store_id)" + "left join address a on (a.address_id=s.address_id) "
                + " left join city cy on (cy.city_id=a.city_id) "
                + " left join country cc on(cc.country_id=cy.country_id) "
                + " left join film_category fc on (fc.film_id=f.film_id) "
                + " left join category c on(c.category_id=fc.category_id) " + " where s.store_id=(?) " + " and "
                + " UPPER(title) LIKE ( ? )";

        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
            System.out.println(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, "%" + title.toUpperCase() + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setReleaseYear(rs.getShort("release_year"));
                film.setLanguage("language");
                film.setOriginalLanguage("original_language");
                film.setLength(rs.getInt("length"));
                film.setRating(rs.getString("rating"));
                film.setSpecialFeatures(rs.getString("special_features"));
                java.sql.Date lastUpdate = rs.getDate("last_update");
                film.setLastUpdate(new java.util.Date(lastUpdate.getTime()));
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
