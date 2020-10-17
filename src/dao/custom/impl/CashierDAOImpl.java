package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CashierDAO;
import entity.Cashier;
import entity.Orderdetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CashierDAOImpl implements CashierDAO {
    @Override
    public String getCashierLastId() throws Exception {
        String sql = "select max(id) from cashier";
        ResultSet rst = CrudUtil.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return "";
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public Cashier validate(String userName) throws SQLException, ClassNotFoundException {
        String sql = "SELECT castID , caslogin , caspassword FROM cashier WHERE caslogin=?";
        ResultSet resultSet = CrudUtil.executeQuery(sql, userName);
        if(resultSet.next()){
            return new Cashier(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
        }
        return null;
    }

    @Override
    public boolean add(Cashier ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into cashier values(?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, ID.getCastID(), ID.getCastName(), ID.getCastBirthDay(), ID.getCastAddress(), ID.getCastPhoto(), ID.getCastlogin(), ID.getCastPassword());
    }

    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM cashier WHERE castID= ?";
        return CrudUtil.executeUpdate(sql, ID);
    }

    @Override
    public boolean update(Cashier ID) throws ClassNotFoundException, SQLException {
        String sql = "update cashier set castName =?,castBirthDay=?,castAddress=?,castPhoto=?,caslogin=?,caspassword=? where castID=?";
        return CrudUtil.executeUpdate(sql, ID.getCastID(), ID.getCastName(), ID.getCastBirthDay(), ID.getCastAddress(), ID.getCastPhoto(), ID.getCastlogin(), ID.getCastPassword());
    }

    @Override
    public Cashier search(String ID) throws ClassNotFoundException, SQLException {
        String sql = "select * from cashier where castID=?";
        ResultSet rst = CrudUtil.executeQuery(sql, ID);
        if (rst.next()) {
            return new Cashier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7));
        }
        return null;
    }

    @Override
    public ObservableList<Cashier> getAll() throws ClassNotFoundException, SQLException {
        String sql = "select * from cashier";
        ResultSet rst = CrudUtil.executeQuery(sql);
        ObservableList<Cashier> allCashier = FXCollections.observableArrayList();
        while (rst.next()) {
            allCashier.add(new Cashier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7)));
        }
        return allCashier;
    }
}
