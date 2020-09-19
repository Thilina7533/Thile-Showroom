package controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {
    @FXML
    private JFXComboBox Combo;
    @FXML
    private JFXComboBox Title;
    @FXML
    void selectOnActionCombo(ActionEvent event) {
        Combo.getSelectionModel().getSelectedItem().toString();
    }

    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Central Province", "Eastern Province ", "Northern Province ",
                "Southern Province", "Western Province ", "North Western Province",
                "North Central Province", "Uva Province", "Sabaragamuwa Province");
        Combo.setItems(list);
        ObservableList<String> list1 = FXCollections.observableArrayList("Mr", "Miss", "Mrs");
        Title.setItems(list1);

    }

    public void selectTitleOnCombo(ActionEvent actionEvent) {
        Title.getSelectionModel().getSelectedItem().toString();
    }
}
