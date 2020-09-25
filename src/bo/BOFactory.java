package bo;

import bo.custom.Impl.CustomerBOImpl;
import dto.CustomerDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();

        }

        return boFactory;
    }

    public enum BOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, CASHIER, SUPLAY, PO;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl() ;


                }
        return null;
    }

    }