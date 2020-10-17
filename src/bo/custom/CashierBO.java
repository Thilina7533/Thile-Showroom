package bo.custom;

import bo.SuperBO;
import dto.CashierDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface CashierBO extends SuperBO {
    static CashierDTO getValidated(String text) {
        return null;
    }

    boolean addCashier(CashierDTO cashier) throws ClassNotFoundException, SQLException;

    boolean deleteCashier(String id) throws ClassNotFoundException, SQLException;

    boolean updateCashier(CashierDTO cashier) throws ClassNotFoundException, SQLException;

    CashierDTO searchCashier(String id) throws ClassNotFoundException, SQLException;

    ObservableList<CashierDTO> getAllCashier() throws ClassNotFoundException, SQLException;

    int getRowCount()throws ClassNotFoundException,SQLException;


}
