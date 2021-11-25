package bo.edu.ucb.BackSoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.BackSoft.bl.CustomerBl;
import bo.edu.ucb.BackSoft.dto.Address;

@RestController()
public class addresApi {
   
    CustomerBl customerBl;
    

    @Autowired
    public addresApi( CustomerBl customerBl) {
       
        this.customerBl = customerBl;
        

    }
    //Address
    @PutMapping(value = "/customer/address/{id}")
    public String updateCustomerAddress(@RequestBody Address address, @PathVariable(name = "id") Integer customerId) {
        return customerBl.updateAddress(customerId, address.getAddress());

    }
}
