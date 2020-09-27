package bo;

import bo.custom.Impl.CashierIBOmpl;
import bo.custom.Impl.CustomerBOImpl;
import bo.custom.Impl.ItemBOImpl;
import bo.custom.Impl.SuplayBOImpl;
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
            case SUPLAY:
                return new SuplayBOImpl() ;
            case CASHIER:
                return new CashierIBOmpl() ;
            case ITEM:
                return new ItemBOImpl() ;

                }
        return null;
    }

    }