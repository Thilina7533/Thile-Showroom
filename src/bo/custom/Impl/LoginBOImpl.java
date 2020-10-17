package bo.custom.Impl;

import bo.custom.LoginBO;
import dao.DAOFactory;
import dao.custom.CashierDAO;
import dto.CashierDTO;
import entity.Cashier;

import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {
    CashierDAO cashierDAO = (CashierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CASHIER);

    @Override
    public CashierDTO getValidated(String userName) throws SQLException, ClassNotFoundException {
//        Cashier validate = usersDAO.validate(userName);
//        return new UsersDTO(validate.getUser_name(),validate.getUser_password(),validate.getPosition());
        Cashier cus = cashierDAO.validate(userName);
        return new CashierDTO(cus.getCastID(),cus.getCastlogin(),cus.getCastPassword());
    }
}
