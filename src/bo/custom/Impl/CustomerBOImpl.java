package bo.custom.Impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dto.CustomerDTO;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {
//    dao.search(id)
//    searchCustomer(String ID){
//    customerDAO.searsh(id)
//}
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public boolean addCustomer(CustomerDTO ID) throws ClassNotFoundException, SQLException {
        return customerDAO.add(new Customer(ID.getCustID(),ID.getCustTital(),ID.getCustName(),ID.getCustPhoneNo(),ID.getCustAddress(),ID.getCustEmail(),ID.getCity(),ID.getProvince(),ID.getRegDate()));
    }

    @Override
    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO ID) throws ClassNotFoundException, SQLException {
        return customerDAO.update(new Customer(ID.getCustID(),ID.getCustTital(),ID.getCustName(),ID.getCustPhoneNo(),ID.getCustAddress(),ID.getCustEmail(),ID.getCity(),ID.getProvince(),ID.getRegDate()));
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException {
        Customer search = customerDAO.search(id);
        return new CustomerDTO(search.getCustID(),search.getCustTital(),search.getCustName(),search.getCustPhoneNo(),search.getCustAddress(),search.getCustEmail(),search.getCity(),search.getProvince(),search.getRegDate());
    }

    @Override
    public ObservableList<CustomerDTO> getAllCustomer() throws ClassNotFoundException, SQLException {
         ObservableList<Customer> all =customerDAO.getAll();
        ObservableList<CustomerDTO> allCustomers = FXCollections.observableArrayList();
        for (Customer ID : all) {
            CustomerDTO dto = new CustomerDTO(ID.getCustID(),ID.getCustTital(),ID.getCustName(),ID.getCustPhoneNo(),ID.getCustAddress(),ID.getCustEmail(),ID.getCity(),ID.getProvince(),ID.getRegDate());
            allCustomers.add(dto);
        }
        return allCustomers;
    }


    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        return customerDAO.getRowCount();
    }

}

