package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PaymentDAO;
import entity.Orders;
import entity.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean add(Payment ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into payment  values (?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, ID.getPayID(), ID.getCustName(), ID.getAmount(), ID.getDiscount(), ID.getOrderID());
    }
    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM payment WHERE payID= ?";
        return CrudUtil.executeUpdate(sql, ID);
    }
    @Override
    public boolean update(Payment ID) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Payment search(String ID) throws ClassNotFoundException, SQLException {
        String sql = "select * from Payment where payID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        if (rst.next()) {
            return new Payment(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getString(4), rst.getString(5));
        }
        return null;
    }

    @Override
    public ObservableList<Payment> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from payment";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<Payment> allPayment = FXCollections.observableArrayList();
        while (rst.next()) {
            allPayment.add(new Payment(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getString(4), rst.getString(5)));
        }
        return allPayment;
    }
}
