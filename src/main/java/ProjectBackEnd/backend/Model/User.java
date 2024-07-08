package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

    private @Id
    @GeneratedValue Long id;
    private String name;
    private String userName;
    private String password;
    private String address;
    private int contactInformation;

    User(){}

    public User(String name, String userName, String password, String address,
            int contactInformation) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.contactInformation = contactInformation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactInformation(int contactInformation) {
        this.contactInformation = contactInformation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public int getContactInformation() {
        return contactInformation;
    }

    



    
}
