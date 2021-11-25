package bo.edu.ucb.BackSoft.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dao.RentalDao;
import bo.edu.ucb.BackSoft.dto.Rental;
import bo.edu.ucb.BackSoft.exception.SakilaException;


@Component
public class RentalBl {
    private final RentalDao rentalDao;

    @Autowired
    public RentalBl(RentalDao rentalDao) {
        this.rentalDao = rentalDao;
    }
    public String createRental(Rental rental){
        return rentalDao.createRental(rental);
        
    }
}
