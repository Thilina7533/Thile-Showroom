package dao;

import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.SuplayDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, BATCH, CASHIER, PAYMENT, SUPLAY,
    }

    public SuperDAO getDAO(DAOFactory.DAOTypes Types) {
        switch (Types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case SUPLAY:
                return new SuplayDAOImpl();

            default:
                return null;
        }

    }
}