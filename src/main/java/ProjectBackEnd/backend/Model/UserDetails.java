package ProjectBackEnd.backend.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "user_detail")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDetailId;
    private String mobileNum;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_userdetail", 
      joinColumns = 
        { @JoinColumn(name = "user_detail_id", referencedColumnName = "userDetailId") },
      inverseJoinColumns = 
        { @JoinColumn(name = "user_id", referencedColumnName = "userId") })
    private User user;

    UserDetails(){}

    public UserDetails(String mobileNum, String address) {
        this.mobileNum = mobileNum;
        this.address = address;
    }

    public Long getUserDetailId() {
        return userDetailId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}