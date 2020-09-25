package dao;

import entity.Customer;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CrudDAO<T,ID>  extends SuperDAO{

    boolean add(T ID) throws ClassNotFoundException, SQLException;

    boolean delete(ID ID) throws ClassNotFoundException, SQLException;

    boolean update(T ID) throws ClassNotFoundException, SQLException;

    T search(ID ID) throws ClassNotFoundException, SQLException;

    ObservableList<T> getAll() throws ClassNotFoundException, SQLException;
}
