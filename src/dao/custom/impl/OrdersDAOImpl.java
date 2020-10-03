package dao.custom.impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import dao.CrudUtil;
import dao.custom.OrdersDAO;
import entity.Orderdetail;
import entity.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersDAOImpl implements OrdersDAO {


    @Override
    public boolean add(Orders ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into Orders values(?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,ID.getOrderID(),ID.getOrderDate(),ID.getOrderTime(),ID.getCustName(),ID.getCustPhoneNo(),ID.getCustAddress(),ID.getCustEmail(),ID.getCastID());
    }

    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM Orders WHERE orderID= ?";
        return CrudUtil.executeUpdate(sql, ID);
    }

    @Override
    public boolean update(Orders ID) throws ClassNotFoundException, SQLException {
        String sql = "update Orders set orderDate=?,orderTime=?,custName=?,custPhoneNo=? ,custAddress=?,custEmail=? ,castID=? where orderID=?";
        return CrudUtil.executeUpdate(sql,ID.getOrderID(),ID.getOrderDate(),ID.getOrderTime(),ID.getCustName(),ID.getCustPhoneNo(),ID.getCustAddress(),ID.getCustEmail(),ID.getCastID());
    }
    @Override
    public Orders search(String ID) throws ClassNotFoundException, SQLException {
        String sql = "select * from Orders where orderID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        if (rst.next()) {
            return new Orders(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8));
        }
        return null;
    }

    @Override
    public ObservableList<Orders> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Orders";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<Orders> allOrders = FXCollections.observableArrayList();
        while (rst.next()) {
            allOrders.add(new Orders(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8)));
        }
        return allOrders;
    }

    @Override
    public String getOrderLastId() throws Exception {
        String sql = "select max(orderID) from orders";
        ResultSet rst = CrudUtil.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return "";
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(orderID) FROM orders";
        ResultSet resultSet = CrudUtil.executeQuery(SQL);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return -1;
    }
}
