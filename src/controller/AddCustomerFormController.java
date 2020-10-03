package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class AddCustomerFormController implements Initializable {

    public JFXTextField txtcustID;
    public JFXTextField txtcustAddress;
    public JFXTextField txtcustName;
    public JFXTextField txtcity;
    public JFXComboBox<String> txtcustTital;
    public JFXComboBox<String> txtprovince;
    public JFXTextField txtEmail;
    public JFXTextField txtRegDate;
    public JFXTextField txtPhoneNo;
    public JFXButton btnDelete;
    public JFXButton btnSearch;
    public JFXButton btnSave;
    public JFXButton btnUpdate;
    public TableColumn<Object, Object> colCustID;
    public TableColumn<Object, Object> colCustTitle;
    public TableColumn<Object, Object> colCustName;
    public TableColumn<Object, Object> colCustPhone;
    public TableColumn<Object, Object> colCustAddress;
    public TableColumn<Object, Object> colCustEmail;
    public TableColumn<Object, Object> colCustCity;
    public TableColumn<Object, Object> colCustProvince;
    public TableColumn<Object, Object> colCustReg;
    public TableView<CustomerDTO> tblCustomer;
    CustomerBO customerBO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerBO = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);
        generateDateTime();
        setTxtcustID();
        colCustID.setCellValueFactory(new PropertyValueFactory<>("custID"));
        colCustTitle.setCellValueFactory(new PropertyValueFactory<>("custTital"));
        colCustName.setCellValueFactory(new PropertyValueFactory<>("custName"));
        colCustPhone.setCellValueFactory(new PropertyValueFactory<>("custPhoneNo"));
        colCustAddress.setCellValueFactory(new PropertyValueFactory<>("custAddress"));
        colCustEmail.setCellValueFactory(new PropertyValueFactory<>("custEmail"));
        colCustCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colCustProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colCustReg.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
        loadAllCustomer();
    }

    private void loadAllCustomer() {
        try {
            ObservableList<CustomerDTO> allCustomers = customerBO.getAllCustomer();
            tblCustomer.setItems(allCustomers);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void generateDateTime() {
        this.txtRegDate.setText(LocalDate.now().toString());
    }

    public void setTxtcustID() {
        try {
            int id = this.customerBO.getRowCount();
            if (id == 0) {
                this.txtcustID.setText("C001");
            }

            if (id > 0 && id <= 8) {
                this.txtcustID.setText("C00" + (id + 1));
            }

            if (id >= 9 && id <= 98) {
                this.txtcustID.setText("C0" + (id + 1));
            }

            if (id >= 99) {
                this.txtcustID.setText("C" + (id + 1));
            }
        } catch (ClassNotFoundException | SQLException var2) {
            var2.printStackTrace();
        }
        //customer Count Code
    }


    public void CustomerAddOnAction() {
        try {
            boolean isAdded = customerBO.addCustomer(new CustomerDTO(
                    txtcustID.getText(),
                    txtcustTital.getValue(),
                    txtcustName.getText(),
                    txtPhoneNo.getText(),
                    txtcustAddress.getText(),
                    txtEmail.getText(),
                    txtcity.getText(),
                    txtprovince.getValue(),
                    txtRegDate.getText()));
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Customer Added Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Added Successful";
                message = "Customer Is Added";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllCustomer();

            } else {
                (new Alert(Alert.AlertType.ERROR, "Customer Not Added ", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Added Un Successful";
                message = "Customer Is Not Added";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            String tilte = "Customer Is Already On The Sever";
            String message = "Customer Is Not Added";
            tray.notification.TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.NOTICE);
            tray.showAndDismiss(Duration.millis(3000));
        }
        //Customer Add Is Over(With Notification)
    }

    public void customerDeleteOnAction() {
        String ID = txtcustID.getText();
        try {
            boolean isDelete = customerBO.deleteCustomer(ID);
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (isDelete) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Customer Delete Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Delete Success";
                message = "Customer Is Deleted";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllCustomer();
            } else {
                (new Alert(Alert.AlertType.ERROR, "Customer Not Delete", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Customer Not Found";
                message = "Sorry";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.NOTICE);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (SQLException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        //Customer Delete Is Over(With Notification)
    }

    public void searchCustomerOnAction() {
        try {
            String customerID = txtcustID.getText();
            CustomerDTO searchCustomer = customerBO.searchCustomer(customerID);
            if (searchCustomer != null) {
                txtcustID.setText(searchCustomer.getCustID());
                txtcustTital.setValue(searchCustomer.getCustTital());
                txtcustName.setText(searchCustomer.getCustName());
                txtPhoneNo.setText(searchCustomer.getCustPhoneNo());
                txtcustAddress.setText(searchCustomer.getCustAddress());
                txtEmail.setText(searchCustomer.getCustEmail());
                txtcity.setText(searchCustomer.getCity());
                txtprovince.setValue(searchCustomer.getProvince());
                txtRegDate.setText(searchCustomer.getRegDate());
                String tilte = "Customer Searched ";
                String message = "Customer Is " + "" + txtcustName.getText() + "";
                tray.notification.TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;

                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(3000));


            } else {
                String tilte = "Searched Customer Not Found";
                String message = "Try Again";
                tray.notification.TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;

                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                tray.showAndDismiss(Duration.millis(3000));
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        //Customer Search Is Over(With Notification)
    }

    public void updateOnAction() {

        try {
            String custID = txtcustID.getText();
            String custTital = txtcustTital.getValue();
            String custName = txtcustName.getText();
            String PhoneNo = txtPhoneNo.getText();
            String custAddress = txtcustAddress.getText();
            String Email = txtEmail.getText();
            String city = txtcity.getText();
            String province = txtprovince.getValue();
            String RegDate = txtRegDate.getText();
            CustomerDTO customerDTO = new CustomerDTO(custID, custTital, custName, PhoneNo, custAddress, Email, city, province, RegDate);
            boolean updateCustomer = customerBO.updateCustomer(customerDTO);
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (updateCustomer) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Customer Update Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Update Successful";
                message = "Customer Is Updated";

                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllCustomer();
            } else {
                (new Alert(Alert.AlertType.ERROR, "Customer Not Update ", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Update Un Successful";
                message = "Customer Is Not Updated";

                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //Customer Update Is Over(With Notification)
    }

    public void tblMouseClick() {
        CustomerDTO c = tblCustomer.getSelectionModel().getSelectedItem();
        txtcustID.setText(c.getCustID());
        txtcustTital.setValue(c.getCustTital());
        txtcustName.setText(c.getCustName());
        txtPhoneNo.setText(c.getCustPhoneNo());
        txtcustAddress.setText(c.getCustAddress());
        txtEmail.setText(c.getCustEmail());
        txtcity.setText(c.getCity());
        txtprovince.setValue(c.getProvince());
        txtRegDate.setText(c.getRegDate());
    }
}
