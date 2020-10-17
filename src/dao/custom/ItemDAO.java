package dao.custom;

import TM.dtmTM;
import dao.CrudDAO;
import entity.Item;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item,String> {
    String getItemLastId() throws Exception;

    int getRowCount() throws ClassNotFoundException, SQLException;

    boolean updateStock(dtmTM orderDetail) throws ClassNotFoundException, SQLException;
}
