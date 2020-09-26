package entity;

public class Customer {
    private String custID;
    private String custTital;
    private String custName;
    private String custPhoneNo;
    private String custAddress;
    private String custEmail;
    private String city;
    private String province;
    private String RegDate;

    public Customer(String custID, String custTital, String custName, String custPhoneNo, String custAddress, String custEmail, String city, String province, String regDate) {
        this.custID = custID;
        this.custTital = custTital;
        this.custName = custName;
        this.custPhoneNo = custPhoneNo;
        this.custAddress = custAddress;
        this.custEmail = custEmail;
        this.city = city;
        this.province = province;
        RegDate = regDate;
    }



    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCustTital() {
        return custTital;
    }

    public void setCustTital(String custTital) {
        this.custTital = custTital;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }
}
