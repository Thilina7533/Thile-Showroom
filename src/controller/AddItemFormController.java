package controller;

import bo.BOFactory;
import bo.custom.CustomerBO;
import bo.custom.ItemBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CustomerDTO;
import dto.ItemDTO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import javax.swing.table.DefaultTableModel;


import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddItemFormController implements Initializable {
    public JFXTextField txtItemId;
    public JFXTextField txtPackSize;
    public JFXTextField TxtQty;
    public JFXTextField txtDescription;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtSupID;
    public JFXTextField txtBatchId;
    public TableView tblItem;
    public TableColumn colItemId;
    public TableColumn colSupId;
    public TableColumn colDes;
    public TableColumn colPack;
    public TableColumn colPrice;
    public TableColumn colQty;
    public TableColumn colBath;
    ItemBO itemBO;
    DefaultTableModel dtm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ITEM);
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colSupId.setCellValueFactory(new PropertyValueFactory<>("suplayerID"));
        colDes.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colPack.setCellValueFactory(new PropertyValueFactory<>("packSize"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("QtyOnHand"));
        colBath.setCellValueFactory(new PropertyValueFactory<>("BatchID"));
        loadAllItems();
        setTxtItemId();
    }

    private void loadAllItems() {
        try {
            ObservableList<ItemDTO> allItem = itemBO.getAllItem();
            tblItem.setItems(allItem);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void setTxtItemId() {
        try {
            int id = this.itemBO.getRowCount();
            if (id == 0) {
                this.txtItemId.setText("I001");
            }

            if (id > 0 && id <= 8) {
                this.txtItemId.setText("I00" + (id + 1));
            }

            if (id >= 9 && id <= 98) {
                this.txtItemId.setText("I0" + (id + 1));
            }

            if (id >= 99) {
                this.txtItemId.setText("I" + (id + 1));
            }
        } catch (ClassNotFoundException | SQLException var2) {
            var2.printStackTrace();
        }
        //customer Count Code
    }

    public void addOnAction(ActionEvent actionEvent) {


        try {
            boolean isAdded = itemBO.addItem(new ItemDTO(
                    txtItemId.getText(),
                    txtSupID.getText(),
                    txtDescription.getText(),
                    txtPackSize.getText(),
                    TxtQty.getText(),
                    txtUnitPrice.getText(),
                    txtBatchId.getText()));


            String tilte;
            String message;
            tray.notification.TrayNotification tray = new tray.notification.TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (isAdded) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Item Added Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Added Successful";
                message = "Item Is Added";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllItems();
            } else {
                (new Alert(Alert.AlertType.ERROR, "Item Not Added ", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Added Un Successful";
                message = "Item Is Not Added";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.ERROR);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            String tilte = "Item Is Already On The Sever";
            String message = "Item Is Not Added";
            tray.notification.TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            tray.setTitle(tilte);
            tray.setMessage(message);
            tray.setNotificationType(NotificationType.NOTICE);
            tray.showAndDismiss(Duration.millis(3000));
        }


    }

    public void searchOnAction(ActionEvent actionEvent) {
        try {
            String itemID = txtItemId.getText();
            ItemDTO searchItem = itemBO.searchItem(itemID);
            if (searchItem != null) {
                txtItemId.setText(searchItem.getItemCode());
                txtPackSize.setText(searchItem.getPackSize());
                TxtQty.setText(searchItem.getQtyOnHand());
                txtDescription.setText(searchItem.getDescription());
                txtUnitPrice.setText(searchItem.getUnitPrice());
                txtSupID.setText(searchItem.getSuplayerID());
                txtBatchId.setText(searchItem.getBatchID());
                String tilte = "Item Searched ";
                String message = "Item Is " + "" + txtItemId.getText() + "Found";
                tray.notification.TrayNotification tray = new TrayNotification();
                AnimationType type = AnimationType.POPUP;

                tray.setAnimationType(type);
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.millis(3000));


            } else {
                String tilte = "Searched Item Is Not Found";
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
        //Item Search Is Over(With Notification)
    }


    public void updateOnAction(ActionEvent actionEvent) {

        try {
            String itemCode = txtItemId.getText();
            String suplayerID = txtSupID.getText();
            String Description = txtDescription.getText();
            String packSize = txtPackSize.getText();
            String unitPrice = txtUnitPrice.getText();
            String QtyOnHand = TxtQty.getText();
            String BatchID = txtBatchId.getText();
            ItemDTO itemDTO = new ItemDTO(itemCode, suplayerID, Description, packSize, unitPrice, QtyOnHand, BatchID);
            boolean updateItem = itemBO.updateItem(itemDTO);
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (updateItem) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Item Update Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Update Successful";
                message = "Item Is Updated";

                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllItems();
            } else {
                (new Alert(Alert.AlertType.ERROR, "Item Not Update", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Update Un Successful";
                message = "Item Is Not Updated";

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

    public void deleteOnAction(ActionEvent actionEvent) {
        String ID = txtItemId.getText();
        try {
            boolean isDelete = itemBO.deleteItem(ID);
            String tilte;
            String message;
            TrayNotification tray = new TrayNotification();
            AnimationType type = AnimationType.POPUP;
            tray.setAnimationType(type);
            if (isDelete) {
                (new Alert(Alert.AlertType.CONFIRMATION, "Item Delete Successfully", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Delete Success";
                message = "Item Is Deleted";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.SUCCESS);
                loadAllItems();
            } else {
                (new Alert(Alert.AlertType.ERROR, "Item Not Delete", new ButtonType[]{ButtonType.OK})).show();
                tilte = "Item Not Found";
                message = "Sorry";
                tray.setTitle(tilte);
                tray.setMessage(message);
                tray.setNotificationType(NotificationType.NOTICE);
            }
            tray.showAndDismiss(Duration.millis(3000));
        } catch (SQLException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void tblItemOnAction(MouseEvent mouseEvent) {

    }
}