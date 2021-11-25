package bo.edu.ucb.BackSoft.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dto.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Component
public class PaymentDao {
    private DataSource dataSource;

    @Autowired
    public PaymentDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String createPayment(Payment payment) {
        String msj="";
        String query = "INSERT INTO payment VALUES ((select max(p.payment_id) from payment p) + 1 ,(?),(?),(?),(?),now(),now())";

        try (
            Connection conn = dataSource.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(query);

        ) {

            pstmt.setInt(1, payment.getCustomerId());
            pstmt.setInt(2, payment.getStaffId());
            pstmt.setInt(3, payment.getRentalId());
            pstmt.setDouble(4, payment.getMont());

            pstmt.executeUpdate();
            msj="Agregado Sara :)";
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return msj;

    }
    
}
