package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;
import entity.Orderdetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public String getCustomerLastId() throws SQLException, ClassNotFoundException {
        String sql = "select max(id) from Customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return "";
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(custID) FROM customer";
        ResultSet resultSet = CrudUtil.executeQuery(SQL);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return -1;}

    @Override
    public boolean add(Customer ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into customer values(?,?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, ID.getCustID(), ID.getCustTital(), ID.getCustName(), ID.getCustPhoneNo(), ID.getCustAddress(), ID.getCustEmail(), ID.getCity(), ID.getProvince(), ID.getRegDate());
    }

    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM customer WHERE custID= ?";
        return CrudUtil.executeUpdate(sql, ID);
    }

    @Override
    public boolean update(Customer ID) throws ClassNotFoundException, SQLException {
        String sql = "update Customer set custTital =?,custName=?,custPhoneNo=?,custAddress=?,custEmail=?,city=?,province=?,RegDate=? where custID=?";
        return CrudUtil.executeUpdate(sql, ID.getCustTital(), ID.getCustName(), ID.getCustPhoneNo(), ID.getCustAddress(), ID.getCustEmail(), ID.getCity(), ID.getProvince(), ID.getRegDate(), ID.getCustID());
    }

    @Override
    public Customer search(String ID) throws ClassNotFoundException, SQLException {
        String sql = "select * from Customer where custID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        if (rst.next()) {
            return new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));
        }
        return null;
    }


    @Override
    public ObservableList<Customer> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Customer";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<Customer> allCustomers = FXCollections.observableArrayList();
        while (rst.next()) {
            allCustomers.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9)));
        }
        return allCustomers;
    }
}
