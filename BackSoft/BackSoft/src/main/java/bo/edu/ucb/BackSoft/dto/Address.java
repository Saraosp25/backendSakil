package bo.edu.ucb.BackSoft.dto;

public class Address {
    private Integer idAddress;
    private String address;
    public String getAddress() {
        return address;
    }
    public Integer getIdAddress() {
        return idAddress;
    }
    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
