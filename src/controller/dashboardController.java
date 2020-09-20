package controller;


import animatefx.animation.*;

import animatefx.util.ParallelAnimationFX;
import animatefx.util.SequentialAnimationFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardController {
    public Pane context;



    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().
                getResource("/view/" + location + ".fxml")));
    }

    public void DashBoardOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashboardForm");
        new Flash(context).play();

    }

    public void AddItemOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddItemForm");
        new Flip(context).play();

    }

    public void btnAddCashier(ActionEvent actionEvent) throws IOException {
        setUi("AddCashierForm");
        new FadeInUp(context).play();
    }


    public void btnLogOut(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.close();
    }

    public void btnAddCustomer(ActionEvent actionEvent) throws IOException {
        setUi("AddCustomerForm");
        new BounceIn(context).play();
    }
    public void btnReportOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Report");
        new ZoomIn(context).play();
    }
    public void btnAboutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AboutForm");
        new RotateIn(context).play();
    }
    public void btnSuplayerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddSuply");
        new RubberBand(context).play();
    }

    public void btnCloaseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.close();
    }

}



