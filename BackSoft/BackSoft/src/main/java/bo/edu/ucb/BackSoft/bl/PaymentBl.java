package bo.edu.ucb.BackSoft.bl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bo.edu.ucb.BackSoft.dao.PaymentDao;
import bo.edu.ucb.BackSoft.dto.Payment;

@Component
public class PaymentBl {
    private final PaymentDao paymentDao;

    @Autowired
    public PaymentBl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }
    public String createPayment(Payment payment){
        return paymentDao.createPayment(payment);
        
    }
}
