package dto;

import java.sql.Blob;
import java.util.Date;

public class CashierDTO {
    private String castID;
    private String castName;
    private Date castBirthDay;
    private String castAddress;
    private Blob castPhoto;
    private String caslogin;

    public String getCastID() {
        return castID;
    }

    public void setCastID(String castID) {
        this.castID = castID;
    }

    public String getCastName() {
        return castName;
    }

    public void setCastName(String castName) {
        this.castName = castName;
    }

    public Date getCastBirthDay() {
        return castBirthDay;
    }

    public void setCastBirthDay(Date castBirthDay) {
        this.castBirthDay = castBirthDay;
    }

    public String getCastAddress() {
        return castAddress;
    }

    public void setCastAddress(String castAddress) {
        this.castAddress = castAddress;
    }

    public Blob getCastPhoto() {
        return castPhoto;
    }

    public void setCastPhoto(Blob castPhoto) {
        this.castPhoto = castPhoto;
    }

    public String getCaslogin() {
        return caslogin;
    }

    public void setCaslogin(String caslogin) {
        this.caslogin = caslogin;
    }

    public String getCaspassword() {
        return caspassword;
    }

    public void setCaspassword(String caspassword) {
        this.caspassword = caspassword;
    }

    public CashierDTO() {
    }

    public CashierDTO(String castID, String castName, Date castBirthDay, String castAddress, Blob castPhoto, String caslogin, String caspassword) {
        this.castID = castID;
        this.castName = castName;
        this.castBirthDay = castBirthDay;
        this.castAddress = castAddress;
        this.castPhoto = castPhoto;
        this.caslogin = caslogin;
        this.caspassword = caspassword;
    }

    private String caspassword;

}
