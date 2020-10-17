package bo.custom;
import bo.SuperBO;
import dto.ItemDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {

    boolean addItem(ItemDTO Item) throws ClassNotFoundException, SQLException;

    boolean deleteItem(String id) throws ClassNotFoundException, SQLException;

    boolean updateItem(ItemDTO id) throws ClassNotFoundException, SQLException;

    ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException;

    ObservableList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException;

    int getRowCount()throws ClassNotFoundException,SQLException;

    //  boolean updateStock(ArrayList<ItemDTO> orderItems) throws SQLException, ClassNotFoundException;

}

