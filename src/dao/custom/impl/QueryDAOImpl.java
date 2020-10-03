package dao.custom.impl;

import dao.custom.QueryDAO;
import entity.CustomEntity;
import entity.Orderdetail;
import entity.Suplay;
import javafx.collections.ObservableList;

import javax.management.Query;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public ArrayList<CustomEntity> getOrderDetailsFromOID(String oid) throws ClassNotFoundException, SQLException {
        return null;
    }
}
