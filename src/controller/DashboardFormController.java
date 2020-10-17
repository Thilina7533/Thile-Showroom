package controller;


import db.DBConnection;
import dto.PaymentDTO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.checkedObservableSet;
import static javafx.collections.FXCollections.observableArrayList;

public class DashboardFormController implements Initializable {
    public Label txtTotalCustomers;
    public Label TotalOrders;
    public Label TotalSales;
    public Label SoldItem;
    public PaymentDTO paymentDTOS;
    public AreaChart areaChart;

    @FXML
    private javafx.scene.chart.PieChart PieChart;
    private void initInfo() throws SQLException, ClassNotFoundException {
        ResultSet set = DBConnection.getInstance().
                getConnection().
                prepareStatement
                        ("SELECT COUNT(custID) FROM Customer")
                .executeQuery();
        if (set.next()) {
            int customerCount = set.getInt(1);
            txtTotalCustomers.setText(String.valueOf(customerCount));
        }

    }
    private void orders () throws SQLException, ClassNotFoundException {
        ResultSet set = DBConnection.getInstance().
                getConnection().
                prepareStatement
                        ("SELECT COUNT(orderID) FROM orders")
                .executeQuery();
        if (set.next()) {
            int customerCount = set.getInt(1);
            TotalOrders.setText(String.valueOf(customerCount));
        }
    }
    private void sales () throws SQLException, ClassNotFoundException {
        ResultSet set = DBConnection.getInstance().
                getConnection().
                prepareStatement
                        ("SELECT \n" +
                                "    SUM(amount) SalesQuantity\n" +
                                "FROM\n" +
                                "    payment")
                .executeQuery();
        if (set.next()) {
            int customerCount = set.getInt(1);
            TotalSales.setText(String.valueOf(customerCount));
        }
    }
    private void soldItem () throws SQLException, ClassNotFoundException {
        ResultSet set = DBConnection.getInstance().
                getConnection().
                prepareStatement
                        ("SELECT \n" +
                                "    SUM(orderQTY) SalesQuantity\n" +
                                "FROM\n" +
                                "    Orderdetail")
                .executeQuery();
        if (set.next()) {
            int customerCount = set.getInt(1);
            SoldItem.setText(String.valueOf(customerCount));
        }
    }

    public void loadPieChart() throws SQLException, ClassNotFoundException {
        ObservableList<PieChart.Data> pieChartData = observableArrayList(
                new PieChart.Data("January", 13),
                new PieChart.Data("February", 25),
                new PieChart.Data("March", 10),
                new PieChart.Data("April", 43),
                new PieChart.Data("April", 25),
                new PieChart.Data("May", 22),
                new PieChart.Data("June", 12),
                new PieChart.Data("July", 82),
                new PieChart.Data("August", 22),
                new PieChart.Data("September", 32),
                new PieChart.Data("October", 24),
                new PieChart.Data("November", 22),
                new PieChart.Data("December", 22));
        PieChart.setData(pieChartData);

        XYChart.Series series =new XYChart.Series();
        series.getData().add(new XYChart.Data("1",23));
        series.getData().add(new XYChart.Data("2",65));
        series.getData().add(new XYChart.Data("3",68));
        series.getData().add(new XYChart.Data("4",32));
        series.getData().add(new XYChart.Data("5",56));
        series.getData().add(new XYChart.Data("6",76));
        series.getData().add(new XYChart.Data("7",44));
        areaChart.getData().add(series);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            initInfo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            orders ();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            sales ();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            soldItem ();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            loadPieChart();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    }

