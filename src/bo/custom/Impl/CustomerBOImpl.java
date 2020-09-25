package bo.custom.Impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean addCustomer(CustomerDTO ID) throws ClassNotFoundException, SQLException {
        return customerDAO.add(new Customer(ID.getCustID(),ID.getCustTital(),ID.getCustName(),ID.getCustPhoneNo(),ID.getCustAddress(),ID.getCustEmail(),ID.getCity(),ID.getProvince(),ID.getRegDate()));
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

