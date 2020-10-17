package dao.custom;

import dao.CrudDAO;
import entity.Cashier;

import java.sql.SQLException;

public interface CashierDAO extends CrudDAO<Cashier,String> {
    String getCashierLastId()throws Exception;
    int getRowCount()throws ClassNotFoundException, SQLException;
    Cashier validate(String userName) throws SQLException, ClassNotFoundException;
}
