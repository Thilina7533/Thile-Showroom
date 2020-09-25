package bo.custom.Impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean addCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO id) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<CustomerDTO> getAllStudent() throws ClassNotFoundException, SQLException {
        return null;
    }

    }

