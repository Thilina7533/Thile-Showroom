package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderdetailDAO;
import entity.Item;
import entity.Orderdetail;
import entity.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderdetailDAOImpl implements OrderdetailDAO {
    @Override
    public boolean add(Orderdetail ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into orderdetail values(?,?,?,?)";
        return CrudUtil.executeUpdate(sql,ID.getOrderID(),ID.getItemCode(),ID.getOrderQTY(),ID.getUnitPrice());
    }


    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM orderdetail WHERE orderID= ?";
        return CrudUtil.executeUpdate(sql, ID);
    }
    @Override
    public boolean update(Orderdetail ID) throws ClassNotFoundException, SQLException {
        String sql = "update orderdetail set itemCode=?,orderQTY=?,unitPrice=?,Discount=? where orderID=?";
        return CrudUtil.executeUpdate(sql,ID.getItemCode(),ID.getOrderQTY(),ID.getUnitPrice(),ID.getOrderID());
    }

    @Override
    public Orderdetail search(String ID) throws ClassNotFoundException, SQLException {
        String sql = "select * from orderdetail where orderID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        if (rst.next()) {
            return new Orderdetail(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
        }
        return null;
    }

    @Override
    public ObservableList<Orderdetail> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from orderdetail";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<Orderdetail> allOrderDetails = FXCollections.observableArrayList();
        while (rst.next()) {
            allOrderDetails.add(new Orderdetail(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4)));
        }
        return allOrderDetails;
    }
}
