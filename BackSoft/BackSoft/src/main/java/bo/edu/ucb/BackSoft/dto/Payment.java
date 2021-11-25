package bo.edu.ucb.BackSoft.dto;

public class Payment {
    private Integer customerId;
    private Integer staffId;
    private Integer rentalId;
    private Double mont;

    public Integer getCustomerId() {
        return customerId;
    }
    public Double getMont() {
        return mont;
    }
    public void setMont(Double mont) {
        this.mont = mont;
    }
    public Integer getRentalId() {
        return rentalId;
    }
    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }
    public Integer getStaffId() {
        return staffId;
    }
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }



}
