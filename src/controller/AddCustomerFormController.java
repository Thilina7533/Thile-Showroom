package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import bo.custom.RegisterBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AddCustomerFormController {

    public JFXTextField txtcustID;
    public JFXTextField txtcustAddress;
    public JFXTextField txtcustName;
    public JFXTextField txtcity;
    public JFXComboBox txtcustTital;
    public JFXComboBox txtprovince;
    public JFXTextField txtEmail;
    public JFXTextField txtRegDate;
    public JFXTextField txtPhoneNo;
    CustomerBO customerBO;

    public AddCustomerFormController() {

        this.customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    }
    public void CustomerAddOnAction(ActionEvent actionEvent) throws Exception {
        ObservableList regDetails = FXCollections.observableArrayList();
        regDetails.add(new CustomerDTO(this.txtcustID.getText(),this.txtcustName.getText(),this.txtcustTital.getSelectionModel(),this.txtPhoneNo.getText(),this.txtEmail.getText(),this.txtcustAddress.getText(),this.txtcity.getText(),this.txtprovince.getSelectionModel(),this.txtRegDate.getText()));
        CustomerDTO customerDTO = new CustomerDTO(this.txtcustID.getText(),this.txtcustName.getText(),this.txtcustTital.getSelectionModel(),this.txtPhoneNo.getText(),this.txtEmail.getText(),this.txtcustAddress.getText(),this.txtcity.getText(),this.txtprovince.getSelectionModel(),this.txtRegDate.getText());
        boolean isAddCustomer = RegisterBO.addCustomer(customerDTO);
        if (isAddCustomer) {
            (new Alert(Alert.AlertType.CONFIRMATION, "Customer Registerd", new ButtonType[]{ButtonType.OK})).show();
        }else {
            (new Alert(Alert.AlertType.CONFIRMATION, "NO Customer Registerd", new ButtonType[]{ButtonType.OK})).show();
        }
    }

    }

