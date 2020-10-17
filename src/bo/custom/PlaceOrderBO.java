package bo.custom;

import bo.SuperBO;
import bo.custom.Impl.PlaceOrderBOImpl;
import dto.CashierDTO;
import dto.CustomDTO;
import dto.ItemDTO;
import dto.OrdersDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PlaceOrderBO extends SuperBO {
    ObservableList<CashierDTO> getAllCashier() throws ClassNotFoundException, SQLException;

    ObservableList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException;

    CashierDTO searchCashier(String id) throws Exception;

    ItemDTO searchItem(String itemCode) throws Exception;

    boolean placeOrder(OrdersDTO dto) throws ClassNotFoundException, SQLException, Exception;

    ObservableList<CustomDTO> searchOrderFromID(String id) throws ClassNotFoundException, SQLException, Exception;

    int getRowCount()throws ClassNotFoundException,SQLException;

   // boolean updateStock(ArrayList<ItemDTO> orderItems) throws SQLException, ClassNotFoundException;

}
