package bo.edu.ucb.BackSoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dto.Film;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Component
public class FilmPaisDao {
    private DataSource dataSource;

    @Autowired
    public FilmPaisDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Film> findByFilmCountry(Integer id) {
        List<Film> result = new ArrayList<>();
        String query = "select distinct f.film_id, f.title, f.description, co.country" + " from film f"
                + " LEFT JOIN inventory i ON (i.film_id = f.film_id)" + " LEFT JOIN store s ON (s.store_id =i.store_id)"
                + " LEFT JOIN address a ON (a.address_id = s.address_id)"
                + " LEFT JOIN city ci ON (ci.city_id = a.city_id)"
                + " LEFT JOIN country co ON (co.country_id = ci.country_id)" + " where s.store_id = (?)";

        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
            System.out.println(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setCountry(rs.getString("country"));

                result.add(film);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return result;
    }

    public List<Film> findByEstrenos(Integer id) {
        List<Film> result = new ArrayList<>();
        String query = "SELECT DISTINCT f.film_id,f.title,f.description,cc.country" + " FROM film f"
                + " left join inventory i on (i.film_id=f.film_id)"
                + " left join rental r on (r.inventory_id=i.inventory_id)"
                + "  left join store s on (s.store_id=i.store_id)"
                + " left join address a on (a.address_id=s.address_id)" + " left join city cy on (cy.city_id=a.city_id)"
                + " left join country cc on(cc.country_id=cy.country_id)"
                + " left join film_category fc on (fc.film_id=f.film_id)"
                + "  left join category c on(c.category_id=fc.category_id)" + "  where s.store_id=(?)"
                + "  ORDER BY film_id DESC" + " LIMIT 10";

        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
            System.out.println(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setCountry(rs.getString("country"));

                result.add(film);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return result;
    }

    public List<Film> findByWeek(Integer id) {
        List<Film> result = new ArrayList<>();
        String query = "SELECT  f.film_id, f.title, f.description,cc.country" + " FROM  film f "
                + " left join inventory i on (i.film_id=f.film_id)"
                + " left join rental r on (r.inventory_id=i.inventory_id)"
                + " left join store s on (s.store_id=i.store_id)"
                + " left join address a on (a.address_id=s.address_id)" + " left join city cy on (cy.city_id=a.city_id)"
                + " left join country cc on(cc.country_id=cy.country_id)"
                + " left join film_category fc on (fc.film_id=f.film_id)"
                + " left join category c on(c.category_id=fc.category_id)"
                + " WHERE r.rental_date > DATE_SUB('2006-02-15 21:30:53', INTERVAL 1 WEEK)" + "  and s.store_id=(?)"
                + " ORDER BY film_id DESC" + " LIMIT 10";

        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
            System.out.println(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setCountry(rs.getString("country"));

                result.add(film);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return result;
    }

    public List<Film> findBySiempre(Integer id) {
        List<Film> result = new ArrayList<>();
        String query = "select f.film_id,f.title,f.description,cc.country" + " from film f"
                + "  left join inventory i on (i.film_id=f.film_id)"
                + " left join rental r on (r.inventory_id=i.inventory_id)"
                + " left join store s on (s.store_id=i.store_id)" + "left join address a on (a.address_id=s.address_id)"
                + "  left join city cy on (cy.city_id=a.city_id)"
                + "   left join country cc on(cc.country_id=cy.country_id)"
                + " left join language l on (f.language_id=l.language_id)"
                + "  left join film_category fc on (fc.film_id=f.film_id)"
                + " left join category c on(c.category_id=fc.category_id)" + " where s.store_id=(?)"
                + "  group by f.film_id" + " order by count(r.rental_id) desc" + " Limit 10";

        try (Connection conn = dataSource.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
            System.out.println(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Film film = new Film();
                film.setFilmId(rs.getInt("film_id"));
                film.setTitle(rs.getString("title"));
                film.setDescription(rs.getString("description"));
                film.setCountry(rs.getString("country"));

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
