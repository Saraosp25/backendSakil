package bo.edu.ucb.BackSoft.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dao.CustomerDao;
import bo.edu.ucb.BackSoft.dao.RentalDao;
import bo.edu.ucb.BackSoft.dto.Customer;
import bo.edu.ucb.BackSoft.dto.Rental;
import bo.edu.ucb.BackSoft.exception.SakilaException;


@Component
public class CustomerBl {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerBl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    public String createCustomer(Customer customer){
        return customerDao.createCustomer(customer);
        
    }
    /*public List<Customer> updateAddress(String address,Integer id) {
        if (address == null ||id == null ) {
            throw new SakilaException(403, "Bad request: The actor parameter is mandatory and can't be null or empty");
        }
        return customerDao.updateAddress(address,id);
    }*/
}
