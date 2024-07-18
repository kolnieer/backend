package ProjectBackEnd.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AddOns {

    private @Id
    @GeneratedValue Long addOnsId;
    private int pearl;
    private int crystal;
    private int creamCheese;

    AddOns(){}

    public AddOns(int pearl, int crystal, int creamCheese) {
        this.pearl = pearl;
        this.crystal = crystal;
        this.creamCheese = creamCheese;
    }

    public void setAddOnsId(Long addOnsId) {
        this.addOnsId = addOnsId;
    }

    public void setPearl(int pearl) {
        this.pearl = pearl;
    }

    public void setCrystal(int crystal) {
        this.crystal = crystal;
    }

    public void setCreamCheese(int creamCheese) {
        this.creamCheese = creamCheese;
    }

    public Long getAddOnsId() {
        return addOnsId;
    }

    public int getPearl() {
        return pearl;
    }

    public int getCrystal() {
        return crystal;
    }

    public int getCreamCheese() {
        return creamCheese;
    }

}
