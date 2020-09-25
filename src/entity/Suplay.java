package entity;

public class Suplay {
    private String suplayerName;
    private String suplayerAddress;
    private String suplayerPhone;
    private String suplayerEmail;

    public String getSuplayerName() {
        return suplayerName;
    }

    public void setSuplayerName(String suplayerName) {
        this.suplayerName = suplayerName;
    }

    public String getSuplayerAddress() {
        return suplayerAddress;
    }

    public void setSuplayerAddress(String suplayerAddress) {
        this.suplayerAddress = suplayerAddress;
    }

    public String getSuplayerPhone() {
        return suplayerPhone;
    }

    public void setSuplayerPhone(String suplayerPhone) {
        this.suplayerPhone = suplayerPhone;
    }

    public String getSuplayerEmail() {
        return suplayerEmail;
    }

    public void setSuplayerEmail(String suplayerEmail) {
        this.suplayerEmail = suplayerEmail;
    }

    public Suplay() {
    }

    public Suplay(String suplayerName, String suplayerAddress, String suplayerPhone, String suplayerEmail) {
        this.suplayerName = suplayerName;
        this.suplayerAddress = suplayerAddress;
        this.suplayerPhone = suplayerPhone;
        this.suplayerEmail = suplayerEmail;
    }
}
