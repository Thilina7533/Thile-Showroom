package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.SuplayDAO;
import entity.Orderdetail;
import entity.Suplay;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SuplayDAOImpl implements SuplayDAO {
    @Override
    public boolean add(Suplay ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into suplay values(?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, ID.getSuplayerID(),ID.getSuplayerName(),ID.getSuplayerAddress(),ID.getSuplayerPhone(),ID.getSuplayerEmail());
    }

    @Override
    public boolean delete(String ID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM suplay WHERE suplayerID= ?";
        return CrudUtil.executeUpdate(sql, ID);
    }

    @Override
    public boolean update(Suplay ID) throws ClassNotFoundException, SQLException {
        String sql = "update suplay set suplayerName =?,suplayerAddress=?,suplayerPhone=?,suplayerEmail=? where suplayerID=?";
        return CrudUtil.executeUpdate(sql, ID.getSuplayerName(), ID.getSuplayerAddress(), ID.getSuplayerPhone(), ID.getSuplayerEmail(),ID.getSuplayerID());
    }

    @Override
    public Suplay search(String ID) throws ClassNotFoundException, SQLException {
        String sql = "select * from Suplay where suplayerID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        if (rst.next()) {
            return new Suplay(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
        }
        return null;
    }

    @Override
    public ObservableList<Suplay> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from Suplay";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<Suplay> allSuplay = FXCollections.observableArrayList();
        while (rst.next()) {
            allSuplay.add(new Suplay(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)));
        }
        return allSuplay;
    }

    @Override
    public String getSuplayLastId() throws Exception {
        return null;
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(suplayerID) FROM Suplay";
        ResultSet rst = CrudUtil.executeQuery(SQL, new Object[0]);
        return rst.next() ? rst.getInt(1) : -1;
    }
}
