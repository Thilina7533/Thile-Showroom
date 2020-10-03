package entity;

import java.sql.Time;
import java.util.Date;

public class Orders {
    private String orderID;
    private String orderDate;
    private String orderTime;

    private String custName;
    private String custPhoneNo;
    private String custAddress;
    private String custEmail;
    private String castID;

    public Orders(String orderID, String orderDate, String orderTime, String custName, String custPhoneNo, String custAddress, String custEmail, String castID) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.custName = custName;
        this.custPhoneNo = custPhoneNo;
        this.custAddress = custAddress;
        this.custEmail = custEmail;
        this.castID = castID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhoneNo() {
        return custPhoneNo;
    }

    public void setCustPhoneNo(String custPhoneNo) {
        this.custPhoneNo = custPhoneNo;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCastID() {
        return castID;
    }

    public void setCastID(String castID) {
        this.castID = castID;
    }
}
