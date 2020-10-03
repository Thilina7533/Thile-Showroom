package bo.custom.Impl;

import TM.dtmTM;
import bo.custom.PlaceOrderBO;
import dao.DAOFactory;
import dao.custom.*;
import dao.custom.impl.PaymentDAOImpl;
import db.DBConnection;
import dto.*;
import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    CashierDAO cashierDAO = (CashierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CASHIER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderdetailDAO orderdetailDAO = (OrderdetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERYDAO);
    PaymentDAO paymentDAO = new PaymentDAOImpl();


    @Override
    public ObservableList<CashierDTO> getAllCashier() throws ClassNotFoundException, SQLException {
        ObservableList<Cashier> all = cashierDAO.getAll();
        ObservableList<CashierDTO> allCashier = FXCollections.observableArrayList();
        for (Cashier ID : all) {
            CashierDTO dto = new CashierDTO(ID.getCastID(), ID.getCastName(), ID.getCastBirthDay(), ID.getCastAddress(), ID.getCastPhoto(), ID.getCastlogin(), ID.getCastPassword());
            allCashier.add(dto);
        }
        return allCashier;
    }

    @Override
    public ObservableList<ItemDTO> getAllItem() throws ClassNotFoundException, SQLException {
        ObservableList<Item> all = itemDAO.getAll();
        ObservableList<ItemDTO> allItem = FXCollections.observableArrayList();
        for (Item ID : all) {
            ItemDTO dto = new ItemDTO(ID.getItemCode(), ID.getSuplayerID(), ID.getDescription(), ID.getPackSize(), ID.getUnitPrice(), ID.getQtyOnHand(), ID.getBatchID());
            allItem.add(dto);
        }
        return allItem;
    }


    @Override
    public CashierDTO searchCashier(String id) throws Exception {
        Cashier search = cashierDAO.search(id);
        return new CashierDTO(search.getCastID(), search.getCastName(), search.getCastBirthDay(), search.getCastAddress(), search.getCastPhoto(), search.getCastlogin(), search.getCastPassword());
    }

    @Override
    public ItemDTO searchItem(String itemCode) throws Exception {
        Item search = itemDAO.search(itemCode);
        return new ItemDTO(search.getItemCode(), search.getSuplayerID(), search.getDescription(), search.getPackSize(), search.getUnitPrice(), search.getQtyOnHand(), search.getBatchID());
    }

    @Override
    public boolean placeOrder(OrdersDTO dto) throws ClassNotFoundException, SQLException, Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        Orders orders = new Orders(dto.getOrderID(), dto.getOrderDate(), dto.getOrderTime(), dto.getCustName(), dto.getCustPhoneNo(), dto.getCustAddress(), dto.getCustEmail(), dto.getCastID());
        boolean add = ordersDAO.add(orders);
        try {
            if (add) {
                for (dtmTM ord : dto.getAllOrderDetail()) {
                    Orderdetail orderTable = new Orderdetail(dto.getOrderID(), ord.getCode(), ord.getQTY(), ord.getPrice());
                    boolean response = orderdetailDAO.add(orderTable);
                    if (!response) {
                        connection.rollback();
                        return false;
                    }else{
                        boolean b = paymentDAO.add(new Payment(createSalt(),dto.getCustName(), dto.getAmount(), dto.getDiscount(), dto.getOrderID() ));
//
                        if (b){
                            connection.commit();
                            return true;
                        }
                    }
                }
                connection.commit();
                return true;

            } else {
                connection.rollback();
                return false;

            }
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public ObservableList<CustomDTO> searchOrderFromID(String id) throws ClassNotFoundException, SQLException, Exception {
        ObservableList<CustomEntity> od = (ObservableList<CustomEntity>) queryDAO.getOrderDetailsFromOID(id);
        ObservableList<CustomDTO> allDetails = FXCollections.observableArrayList();
        for (CustomEntity C : od) {
            CustomDTO dto = new CustomDTO(C.getOrderID(), C.getItemCode(), C.getOrderQTY(), C.getUnitPrice(), C.getDiscount(), C.getOrderDate(), C.getOrderTime(), C.getCustName(), C.getCustPhoneNo(), C.getCustAddress(), C.getCustEmail(), C.getCastID());
            allDetails.add(dto);
        }
        return allDetails;
    }

    @Override
    public int getRowCount() throws ClassNotFoundException, SQLException {
        return ordersDAO.getRowCount();
    }
    public String createSalt() {
        String ts = String.valueOf(System.currentTimeMillis());
        return "A"+ ts.trim();
    }
}
