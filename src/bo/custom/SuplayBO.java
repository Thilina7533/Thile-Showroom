package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.SuplayDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface SuplayBO extends SuperBO {
    boolean addSuplay(SuplayDTO suplay) throws ClassNotFoundException, SQLException;

    boolean deleteSuplay(String id) throws ClassNotFoundException, SQLException;

    boolean updateSuplay(SuplayDTO suplay) throws ClassNotFoundException, SQLException;

    SuplayDTO searchSuplay(String id) throws ClassNotFoundException, SQLException;

    ObservableList<SuplayDTO> getAllSuplay() throws ClassNotFoundException, SQLException;

    int getRowCount()throws ClassNotFoundException,SQLException;
}
