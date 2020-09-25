package bo.custom;

import bo.BOFactory;
import dto.CustomerDTO;

import java.sql.SQLException;

public class RegisterBO {
    static CustomerBO bo = (CustomerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CUSTOMER);

    public static boolean addCustomer(CustomerDTO customer) throws ClassNotFoundException, SQLException, Exception {
        return bo.addCustomer(customer);
    }
}
