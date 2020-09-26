package dto;

public class SuplayDTO {
    private String suplayerID;
    private String suplayerName;
    private String suplayerAddress;
    private String suplayerPhone;
    private String suplayerEmail;

    public SuplayDTO(String suplayerID, String suplayerName, String suplayerAddress, String suplayerPhone, String suplayerEmail) {
        this.suplayerID = suplayerID;
        this.suplayerName = suplayerName;
        this.suplayerAddress = suplayerAddress;
        this.suplayerPhone = suplayerPhone;
        this.suplayerEmail = suplayerEmail;
    }

    public String getSuplayerID() {
        return suplayerID;
    }

    public void setSuplayerID(String suplayerID) {
        this.suplayerID = suplayerID;
    }

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
}
