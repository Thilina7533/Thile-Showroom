package dao.custom;

import dao.CrudDAO;
import entity.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer,String> {
    String getCustomerLastId()throws Exception;
    int getRowCount()throws ClassNotFoundException, SQLException;
}
