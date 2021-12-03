package bo.edu.ucb.BackSoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dto.Rental;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Component
public class RentalDao {

    private DataSource dataSource;

    @Autowired
    public RentalDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String createRental(Rental rental) {
        String msj="";
        String query = "Insert into rental values((select max(r.rental_id) from rental r)+1, now(),((select i.inventory_id from inventory i where i.film_id=(?) limit 1)),(select customer_id from customer where email= (?)),(?),(?),now())";

        try (
            Connection conn = dataSource.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query);

        ) {

            pstmt.setInt(1, rental.getInventoryId());
            pstmt.setString(2, rental.getEmail());
            pstmt.setString(3, rental.getReturnDate());
            pstmt.setInt(4, rental.getStaffId());
            


            pstmt.executeUpdate();
            msj="Agregado Sara 1";
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return msj;

    }

}
