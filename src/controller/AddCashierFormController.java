package controller;

import bo.BOFactory;
import bo.custom.CashierBO;
import bo.custom.CustomerBO;
import bo.custom.Impl.CashierIBOmpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import com.sun.deploy.xml.GeneralEntity;
import dto.CashierDTO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

public class AddCashierFormController implements Initializable {
    public JFXTextField txtCashierID;
    public JFXTextField txtPassword;
    public JFXTextField txtCashierName;
    public JFXTextField txtLogin;
    public ImageView imageid;
    public JFXButton setOnAction;
    public JFXDatePicker txtCashierBirthDay;
    public JFXTextField txtCashierAddress;
    public JFXTextField picTitle;
    public TableView tblCashier;
    public TableColumn colCashId;
    public TableColumn colCashName;
    public TableColumn colCashAddress;
    public TableColumn colcashBirthDay;

    CashierBO cashierBO = new CashierIBOmpl();
    String picName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cashierBO = (CashierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CASHIER);
        colCashId.setCellValueFactory(new PropertyValueFactory<>("castID"));
        colCashName.setCellValueFactory(new PropertyValueFactory<>("castName"));
        colCashAddress.setCellValueFactory(new PropertyValueFactory<>("castAddress"));
        colcashBirthDay.setCellValueFactory(new PropertyValueFactory<>("castBirthDay"));
        loadAllCashier();
    }

    private void loadAllCashier() {
        try {
            ObservableList<CashierDTO> allCashier = cashierBO.getAllCashier();
            tblCashier.setItems(allCashier);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void setOnAction() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File file = fileChooser.showOpenDialog(null);
        picName = file.getAbsolutePath();

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageid.setImage(image);
        } catch (IOException ignored) {

        }
    }


    public void addOnAction(ActionEvent actionEvent) {
        try {
            boolean isAdded = cashierBO.addCashier(new CashierDTO(
                    txtCashierID.getText(),
                    txtCashierName.getText(),
                    txtCashierBirthDay.getValue().toString(),
                    txtCashierAddress.getText(),
                    picName,
                    txtLogin.getText(),
                    txtPassword.getText()));
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Cashier Added Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Added Successful";
                message = "Cashier Is Added";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllCashier();


            } else {
                (new Alert(Alert.AlertType.ERROR, "Cashier Not Added ", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Added Un Successful";
                message = "Cashier Is Not Added";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            String tilte = "Cashier Is Already On The Sever";
            String message = "Cashier Is Not Added";
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

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            String castID = txtCashierID.getText();
//            String castName = txtCashierName.getText();
//            String castBirthDay = txtCashierBirthDay.getValue().toString();
//            String castAddress =  txtCashierAddress.getText();
//            String castPhoto =    picTitle.getText();
//            String caslogin =     txtCashierID.getText();
//            String caspassword =  txtPassword.getText();
//            CashierDTO cashierDTO = new CashierDTO(castID, castName, castBirthDay, castAddress, castPhoto, caslogin, caspassword);
            CashierDTO searchCashier = cashierBO.searchCashier(txtCashierID.getText());
            System.out.println(searchCashier.toString());
            txtCashierID.setText(searchCashier.getCastID());
            txtCashierName.setText(searchCashier.getCastName());
            txtCashierBirthDay.setValue(LocalDate.parse(searchCashier.getCastBirthDay()));
            txtCashierAddress.setText(searchCashier.getCastAddress());
            setPic(searchCashier.getCastPhoto());
            txtPassword.setText(searchCashier.getCastPassword());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //Customer Update Is Over(With Notification)
    }

    private void setPic(String castPhoto) {
        try {
            File file = new File(castPhoto);
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageid.setImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void testingIcon(ActionEvent actionEvent) {

    }

    public void cashierUpdateOnAction(ActionEvent actionEvent) {
        try {
            String castID = txtCashierID.getText();
            String castName = txtCashierName.getText();
            String castBirthDay = txtCashierBirthDay.getValue().toString();
            String castAddress = txtCashierAddress.getText();
            //String castPhoto = picName.intern();
            String caslogin = txtLogin.getText();
            String caspassword = txtPassword.getText();
            CashierDTO cashierDTO = new CashierDTO(castID, castName, castBirthDay, castAddress, "castPhoto", caslogin, caspassword);
            boolean updateCashier = cashierBO.updateCashier(cashierDTO);
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (updateCashier) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Cashier Not Update ", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Update Successful";
                message = "Cashier Is Updated";

                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllCashier();
            } else {
                (new Alert(Alert.AlertType.ERROR, "Cashier Not Update", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Update Un Successful";
                message = "Cashier Is Not Updated";

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

    public void cashierDeleteOnAction(ActionEvent actionEvent) {
        String ID = txtCashierID.getText();
        try {
            boolean isDelete = cashierBO.deleteCashier(ID);
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (isDelete) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Cashier Delete Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Delete Success";
                message = "Cashier Is Deleted";
                tray.setTitle("Delete Success");
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllCashier();
            } else {
                (new Alert(Alert.AlertType.ERROR, "Cashier Not Deleted", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Cashier Not Found";
                message = "Sorry";
                tray.setTitle("Cashier Not Found");
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.NOTICE);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (SQLException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        //Customer Delete Is Over(With Notification)
    }


    public void tblCashierClick() {
        CashierDTO c = (CashierDTO) tblCashier.getSelectionModel().getSelectedItem();
        txtCashierID.setText(c.getCastID());
        txtCashierName.setText(c.getCastName());
        txtCashierAddress.setText(c.getCastAddress());
        txtCashierBirthDay.setValue(LocalDate.parse(c.getCastBirthDay()));
        txtLogin.setText(c.getCastlogin());
        txtPassword.setText(c.getCastPassword());

    }
}
