package bo.custom;

import bo.SuperBO;
import dto.CashierDTO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    CashierDTO getValidated(String userName) throws SQLException, ClassNotFoundException;
}
