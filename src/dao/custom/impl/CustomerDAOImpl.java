package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public String getCustomerLastId() {
        return null;
    }

    @Override
    public boolean add(Customer ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into customer values(?,?,?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql,ID.getCustID(),ID.getCustTital(),ID.getCustName(),ID.getCustAddress(),ID.getCity(),ID.getProvince(),ID.getRegDate(),ID.getCustPhoneNo(),ID.getCustEmail());
    }

    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Customer ID) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Customer search(String ID) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Customer> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }
}
