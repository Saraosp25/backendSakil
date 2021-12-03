package bo.edu.ucb.BackSoft.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Rental {

    
    private Integer inventoryId;
    private String email;
    private Integer staffId;
    private Date returnDate;


    

    public Integer getInventoryId() {
        return inventoryId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReturnDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date = formatter.format(this.returnDate);

        return date;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

   
   

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

   

    
    

    
}
