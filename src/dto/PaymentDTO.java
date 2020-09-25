package dto;

import java.sql.Time;
import java.util.Date;

public class PaymentDTO {
    private String payID;
    private String custID;
    private Date payDate;
    private Time payTime;
    private Double amount;

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Time getPayTime() {
        return payTime;
    }

    public void setPayTime(Time payTime) {
        this.payTime = payTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentDTO(String payID, String custID, Date payDate, Time payTime, Double amount) {
        this.payID = payID;
        this.custID = custID;
        this.payDate = payDate;
        this.payTime = payTime;
        this.amount = amount;
    }

    public PaymentDTO() {
    }
}
