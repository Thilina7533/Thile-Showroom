package controller;

import animatefx.animation.Bounce;
import animatefx.animation.FadeIn;
import animatefx.animation.FadeInDownBig;
import animatefx.animation.Jello;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane root;


    public void LoginOnAction(ActionEvent actionEvent) throws IOException {

        String userName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();

        if (userName.length() > 0 && password.length() > 0) {
            if (userName.equalsIgnoreCase("thilina")
                    && password.equals("2259")) {
                Stage window = (Stage) this.root.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(this.getClass()
                        .getResource("/view/Dashboard.fxml"))));window.centerOnScreen();



            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!",
                        ButtonType.OK).show();

            }
        } else {
            new Alert(Alert.AlertType.WARNING, "User Name Or Password Empty!",
                    ButtonType.OK).show();
        }

    }

    public void btnCloaseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
}
