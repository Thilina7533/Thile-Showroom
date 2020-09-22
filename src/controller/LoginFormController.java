package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane root;


    public void LoginOnAction() throws IOException {

        String userName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();

        if (userName.length() > 0 && password.length() > 0) {
            if (userName.equalsIgnoreCase("thilina")
                    && password.equals("2259")) {
                Stage window = (Stage) this.root.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/Dashboard.fxml"))));
                window.centerOnScreen();
                String tilte = "Sign In";
                String message = "WELCOME TO KITHSIRI TILES MANEGMET SYSTEM ";
                tray.notification.TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;

                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(3000));

            } else {
                String tilte = "Sign In";
                String message = "Error Username " + "'" + txtUserName.getText() + "'" + ", and Password " + "'" + txtPassword.getText() + "'" + " Wrong";
                tray.notification.TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;

                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
                tray.showAndDismiss(Duration.millis(3000));
            }
        } else {
            String tilte = "Sign In";
            String message = "Empty Username Or Password";
            tray.notification.TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;

            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.INFORMATION);
            tray.showAndDismiss(Duration.millis(3000));
        }
    }


    public void btnCloaseOnAction() {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
}
