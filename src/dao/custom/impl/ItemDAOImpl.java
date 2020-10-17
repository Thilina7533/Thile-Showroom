package dao.custom.impl;

import TM.dtmTM;
import dao.CrudDAO;
import dao.CrudUtil;
import dao.custom.ItemDAO;
import db.DBConnection;
import entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into item  values (?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, ID.getItemCode(), ID.getSuplayerID(), ID.getDescription(), ID.getPackSize(), ID.getUnitPrice(), ID.getQtyOnHand(), ID.getBatchID());
    }

    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM item WHERE itemCode= ?";
        return CrudUtil.executeUpdate(sql, ID);
    }

    @Override
    public boolean update(Item ID) throws ClassNotFoundException, SQLException {
        String sql = "update item set suplayerID=?,Description=?,packSize=?,unitPrice=?,QtyOnHand=?,BatchID=? where itemCode=?";
        return CrudUtil.executeUpdate(sql, ID.getSuplayerID(), ID.getDescription(), ID.getPackSize(), ID.getUnitPrice(), ID.getQtyOnHand(), ID.getBatchID() ,ID.getItemCode());
    }

    @Override
    public Item search(String ID) throws ClassNotFoundException, SQLException {
        String sql = "select * from item where itemCode=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        if (rst.next()) {
            return new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7));
        }
        return null;
    }

    @Override
    public ObservableList<Item> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from item";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<Item> allItems = FXCollections.observableArrayList();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7)));
        }
        return allItems;
    }
    @Override
    public String getItemLastId() throws Exception {
        String sql = "select max(id) from item";
        ResultSet rst = CrudUtil.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return "";
    }
    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(itemCode) FROM item";
        ResultSet rst = CrudUtil.executeQuery(SQL, new Object[0]);
        return rst.next() ? rst.getInt(1) : -1;
    }

    @Override
    public boolean updateStock(dtmTM orderDetail) throws ClassNotFoundException, SQLException {
        String sql="Update item set QtyOnHand=QtyOnHand-? where itemCode=?";
        return CrudUtil.executeUpdate(sql,orderDetail.getQTY(),orderDetail.getCode());
    }

}
