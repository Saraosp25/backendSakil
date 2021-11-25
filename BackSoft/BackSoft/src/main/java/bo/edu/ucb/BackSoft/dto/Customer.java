package bo.edu.ucb.BackSoft.dto;

import java.util.Objects;

public class Customer{
    Integer Customerid;
    private Integer storeId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;


    public Customer
    () {
    }
    

    public Integer getStoreId() {
        return storeId;
    }


    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }


    @Override
    public String toString() {
        return "Customer='" + Customerid
         + '\n' +
        " description='" + firstName + '\n' +
        " lengthLabel='" + lastName + '\n' +
        " lengthLabel='" + email + '\n'

        
        ;
    }
    public Integer getCustomerid(){
        return Customerid;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirsName(String firsName) {
        this.firstName = firsName;
    }

    
}
