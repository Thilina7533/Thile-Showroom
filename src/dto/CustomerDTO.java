package dto;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.scene.control.SingleSelectionModel;

import java.util.Date;

public class CustomerDTO {
    public CustomerDTO(JFXTextField txtcustID, JFXTextField txtcustName, JFXComboBox txtcustTital, JFXTextField txtPhoneNo, JFXTextField txtEmail, JFXTextField txtcustAddress, JFXTextField txtcity, JFXComboBox txtprovince, JFXTextField txtRegDate) {
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

    public SingleSelectionModel getCustName() {
        return custName;
    }

    public void setCustName(SingleSelectionModel custName) {
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

    public SingleSelectionModel getProvince() {
        return province;
    }

    public void setProvince(SingleSelectionModel province) {
        this.province = province;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public CustomerDTO(String custID, String custTital, SingleSelectionModel custName, String custPhoneNo, String custAddress, String custEmail, String city, SingleSelectionModel province, String regDate) {
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

    private String custID;
    private String custTital;
    private SingleSelectionModel custName;
    private String custPhoneNo;
    private String custAddress;
    private String custEmail;
    private String city;
    private SingleSelectionModel province;
    private String RegDate;

}
