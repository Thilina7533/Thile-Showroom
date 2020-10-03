package controller;

import animatefx.animation.FadeIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CashierFormController implements Initializable {
    public Pane context;


    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().
                getResource("/view/" + location + ".fxml")));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            btnPlaceOrderOnAction();
            new FadeIn(context).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnPlaceOrderOnAction() throws IOException {
        setUi("PlaceOrderForm");
        new FadeIn(context).play();
    }

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddCustomerForm");
        new FadeIn(context).play();
    }

    public void btnAboutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AboutForm");
        new FadeIn(context).play();
    }
}
