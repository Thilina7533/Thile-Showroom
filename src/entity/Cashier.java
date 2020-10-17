package entity;

import java.time.LocalDate;

public class Cashier {
    private String castID;
    private String castName;
    private String castBirthDay;
    private String castAddress;
    private String castPhoto;
    private String castlogin;
    private String castPassword;

    public Cashier(String castID, String castName, String castBirthDay, String castAddress, String castPhoto, String castlogin, String castPassword) {
        this.castID = castID;
        this.castName = castName;
        this.castBirthDay = castBirthDay;
        this.castAddress = castAddress;
        this.castPhoto = castPhoto;
        this.castlogin = castlogin;
        this.castPassword = castPassword;
    }

    public Cashier(String castID, String castlogin, String castPassword) {
        this.castID = castID;
        this.castlogin = castlogin;
        this.castPassword = castPassword;
    }

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

    public String getCastBirthDay() {
        return castBirthDay;
    }

    public void setCastBirthDay(String castBirthDay) {
        this.castBirthDay = castBirthDay;
    }

    public String getCastAddress() {
        return castAddress;
    }

    public void setCastAddress(String castAddress) {
        this.castAddress = castAddress;
    }

    public String getCastPhoto() {
        return castPhoto;
    }

    public void setCastPhoto(String castPhoto) {
        this.castPhoto = castPhoto;
    }

    public String getCastlogin() {
        return castlogin;
    }

    public void setCastlogin(String castlogin) {
        this.castlogin = castlogin;
    }

    public String getCastPassword() {
        return castPassword;
    }

    public void setCastPassword(String castPassword) {
        this.castPassword = castPassword;
    }
}

