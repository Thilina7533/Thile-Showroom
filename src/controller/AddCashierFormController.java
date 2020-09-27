package controller;

import bo.custom.CashierBO;
import bo.custom.Impl.CashierIBOmpl;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import com.sun.deploy.xml.GeneralEntity;
import dto.CashierDTO;
import dto.CustomerDTO;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

public class AddCashierFormController {
    public JFXTextField txtCashierID;
    public JFXTextField txtPassword;
    public JFXTextField txtCashierName;
    public JFXTextField txtLogin;
    public ImageView imageid;
    public JFXButton setOnAction;
    public DatePicker txtCashierBirthDay;
    public JFXTextField txtCashierAddress;
    public JFXTextField picTitle;

    CashierBO cashierBO = new CashierIBOmpl();
    String picName;

    public void setOnAction() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File file = fileChooser.showOpenDialog(null);
        picName = file.getName();

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
                tilte = "Added Successful";
                message = "Cashier Is Added";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);



            } else {
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
            String cashierID = txtCashierID.getText();
            CashierDTO searchCashier = cashierBO.searchCashier(cashierID);
            if (searchCashier != null) {
                txtCashierID.setText(searchCashier.getCastID());
                txtCashierName.setText(searchCashier.getCastName());
                txtCashierBirthDay.setValue(LocalDate.parse(searchCashier.getCastBirthDay()));
                txtCashierAddress.setText(searchCashier.getCastAddress());
                txtLogin.setText(searchCashier.getCastlogin());
                picTitle.setText(searchCashier.getCastPhoto());
                BufferedImage bufferedImage = null;
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                imageid.setImage(image);
                txtPassword.setText(searchCashier.getCastPassword());
                try {
                    bufferedImage = ImageIO.read(new File("C:\\Users\\Thilina Dilshan\\Desktop\\"));
                    System.out.println("C:\\Users\\Thilina Dilshan\\Desktop\\"+picTitle+"");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String tilte = "Customer Searched ";
                String message = "Customer Is " + "" + txtCashierID.getText() + "";
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

    public void testingIcon(ActionEvent actionEvent) {

    }
}
