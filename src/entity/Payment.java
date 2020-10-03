package entity;

import java.sql.Time;
import java.util.Date;

public class Payment {
    private String payID;
    private String custName;
    private Double amount;
    private String Discount;
    private String orderID;

    public Payment(String payID, String custName, Double amount, String discount, String orderID) {
        this.payID = payID;
        this.custName = custName;
        this.amount = amount;
        Discount = discount;
        this.orderID = orderID;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}
