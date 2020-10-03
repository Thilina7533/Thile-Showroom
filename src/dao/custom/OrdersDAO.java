package dao.custom;

import dao.CrudDAO;
import entity.Orders;

import java.sql.SQLException;

public interface OrdersDAO extends CrudDAO<Orders,String> {
    String getOrderLastId()throws Exception;
    int getRowCount()throws ClassNotFoundException, SQLException;
}
