package bo.custom.Impl;

import bo.custom.CashierBO;
import dao.DAOFactory;
import dao.custom.CashierDAO;
import dao.custom.CustomerDAO;
import dto.CashierDTO;
import dto.CustomerDTO;
import entity.Cashier;
import entity.Customer;
import javafx.collections.ObservableList;

import java.awt.*;
import java.sql.SQLException;

public class CashierIBOmpl implements CashierBO {
    CashierDAO cashierDAO = (CashierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CASHIER);
    @Override
    public boolean addCashier(CashierDTO cashier) throws ClassNotFoundException, SQLException {
        return cashierDAO.add(new Cashier(cashier.getCastID(),cashier.getCastName(),cashier.getCastBirthDay(),cashier.getCastAddress(), cashier.getCastPhoto(),cashier.getCastlogin(),cashier.getCastPassword()));
    }

    @Override
    public boolean deleteCashier(String id) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean updateCashier(CashierDTO cashier) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public CashierDTO searchCashier(String id) throws ClassNotFoundException, SQLException {
        Cashier search = cashierDAO.search(id);
        return new CashierDTO(search.getCastID(),search.getCastName(),search.getCastBirthDay(),search.getCastAddress(),search.getCastPhoto(),search.getCastlogin(),search.getCastPassword());
    }

    @Override
    public ObservableList<CashierDTO> getAllCashier() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        return 0;
    }
}
