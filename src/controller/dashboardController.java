package controller;


import animatefx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {
    public Pane context;


    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().
                getResource("/view/" + location + ".fxml")));
    }

    public void DashBoardOnAction() throws IOException {
        setUi("DashboardForm");
        new FadeIn(context).play();

    }


    public void btnAddCashier() throws IOException {
        setUi("AddCashierForm");
        new FadeIn(context).play();
    }


    public void btnLogOut() {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.close();
    }

    public void btnAddCustomer() throws IOException {
        setUi("AddCustomerForm");
        new FadeIn(context).play();
    }

    public void btnReportOnAction() throws IOException {
        setUi("Report");
        new FadeIn(context).play();
    }

    public void btnAboutOnAction() throws IOException {
        setUi("AboutForm");
        new FadeIn(context).play();
    }

    public void btnSuplayerOnAction() throws IOException {
        setUi("AddSuply");
        new FadeIn(context).play();
    }

    public void btnCloaseOnAction() {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            DashBoardOnAction();
            new FadeIn(context).play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AddItemOnAction(ActionEvent actionEvent) throws IOException {

        setUi("AddItemForm");
        new FadeIn(context).play();
    }
}



