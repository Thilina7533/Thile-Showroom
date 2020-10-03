package bo;

import bo.custom.Impl.*;

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
        CUSTOMER, ITEM, ORDER, CASHIER, SUPLAY, PO;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl() ;
            case ITEM:
                return new ItemBOImpl() ;
            case SUPLAY:
                return new SuplayBOImpl() ;
            case CASHIER:
                return new CashierIBOmpl() ;
            case PO:
                return new PlaceOrderBOImpl() ;

                }
        return null;
    }

    }