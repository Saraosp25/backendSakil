package bo.edu.ucb.BackSoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dto.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Component
public class CustomerDao {
    private DataSource dataSource;

    @Autowired
    public CustomerDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public String createCustomer(Customer customer) {
        String msj="";
        String query = "INSERT INTO customer VALUES ((select max(c.customer_id) from customer c) + 1,(?),(?),(?),(?),(?),1,now(),now())";

        try (
            Connection conn = dataSource.getConnection(); 
        PreparedStatement pstmt = conn.prepareStatement(query);

        ) {

            pstmt.setInt(1, customer.getStoreId());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getEmail());
            pstmt.setString(5, customer.getAddress());

            pstmt.executeUpdate();

            msj="Agregado Sara 1";
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return msj;

    }
  
    public String updateAddress(Integer id,String direc){
        
        String msj1="";
        String query = "update address inner join customer on customer.address_id=address.address_id set address.address=(?), address.last_update=CURRENT_TIMESTAMP where customer.address_id=(?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
           
            pstmt.setString(1, direc);
            pstmt.setInt(2, id);
            Integer rs= pstmt.executeUpdate();
            pstmt.executeUpdate();
            msj1="Agregado Sara 1";
        } catch (SQLException ex) {
            ex.printStackTrace();
            // TODO gestionar correctamente la excepción
        }
        return msj1;
    }
    
}
