package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.CrudUtil;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AddCustomerFormController implements Initializable{

    CustomerBO customerBO;
    public JFXTextField txtcustID;
    public JFXTextField txtcustAddress;
    public JFXTextField txtcustName;
    public JFXTextField txtcity;
    public JFXComboBox txtcustTital;
    public JFXComboBox txtprovince;
    public JFXTextField txtEmail;
    public JFXTextField txtRegDate;
    public JFXTextField txtPhoneNo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
    }

    public void CustomerAddOnAction(ActionEvent actionEvent) throws Exception {
        try {
            boolean isAdded = customerBO.addCustomer(new CustomerDTO(
                    txtcustID.getText(),
                    txtcustTital.getValue().toString(),
                    txtcustName.getText(),
                    txtPhoneNo.getText(),
                    txtcustAddress.getText(),
                    txtEmail.getText(),
                    txtcity.getText(),
                    txtprovince.getValue().toString(),
                    txtRegDate.getText()));
            if (isAdded) {
                String tilte = "Added Successful";
                String message = "Customer Is Added";
                tray.notification.TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(3000));

            }else {
                String tilte = "Added Un Successful";
                String message = "Customer Is Not Added";
                tray.notification.TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;
                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                tray.showAndDismiss(Duration.millis(3000));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            String tilte = "Customer Is Alrady In System";
            String message = "Customer Is Not Added";
            tray.notification.TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.NOTICE);
            tray.showAndDismiss(Duration.millis(3000));
        }
    }

}

