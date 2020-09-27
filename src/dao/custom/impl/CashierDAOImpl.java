package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CashierDAO;
import entity.Cashier;
import entity.Customer;
import entity.Suplay;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CashierDAOImpl implements CashierDAO {
    @Override
    public String getCashierLastId() throws Exception {
        return null;
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        return 0;
    }

    @Override
    public boolean add(Cashier ID) throws ClassNotFoundException, SQLException {
        String sql = "insert into cashier values(?,?,?,?,?,?,?)";
        return CrudUtil.executeUpdate(sql, ID.getCastID(), ID.getCastName(), ID.getCastBirthDay(), ID.getCastAddress(), ID.getCastPhoto(), ID.getCastlogin(), ID.getCastPassword());
    }

    @Override
    public boolean delete(String ID) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Cashier ID) throws ClassNotFoundException, SQLException {
        return false;
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
        return null;
    }
}
