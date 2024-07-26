package ProjectBackEnd.backend.DTO;

public class UserDetailDTO {
    
    private String email;
    private String mobileNum;
    private String address;

    UserDetailDTO(){}

    public UserDetailDTO(String email, String mobileNum, String address) {
        this.email = email;
        this.mobileNum = mobileNum;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

}