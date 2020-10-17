package bo.custom.Impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import dto.ItemDTO;
import entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);


    @Override
    public boolean addItem(ItemDTO Item) throws ClassNotFoundException, SQLException {
        return itemDAO.add(new Item(Item.getItemCode(), Item.getSuplayerID(), Item.getDescription(), Item.getPackSize(), Item.getUnitPrice(), Item.getQtyOnHand(), Item.getBatchID()));
    }

    @Override
    public boolean deleteItem(String id) throws ClassNotFoundException, SQLException {
        return itemDAO.delete(id);
    }

    @Override
    public boolean updateItem(ItemDTO id) throws ClassNotFoundException, SQLException {
        return itemDAO.update(new Item(id.getItemCode(), id.getSuplayerID(), id.getDescription(), id.getPackSize(), id.getUnitPrice(), id.getQtyOnHand(), id.getBatchID()));
    }

    @Override
    public ItemDTO searchItem(String id) throws ClassNotFoundException, SQLException {
        Item search = itemDAO.search(id);
        return new ItemDTO(search.getItemCode(), search.getSuplayerID(), search.getDescription(), search.getPackSize(), search.getUnitPrice(), search.getQtyOnHand(), search.getBatchID());
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
    public int getRowCount() throws ClassNotFoundException, SQLException {
        return itemDAO.getRowCount();
    }

}

//    @Override
//    public boolean updateStock(ArrayList<ItemDTO> orderItems) throws SQLException, ClassNotFoundException {
//
//        for (ItemDTO orderDetail : orderItems) {
//            boolean isUpdateStock = updateStock(orderDetail);
//            if(!isUpdateStock){
//                return false;
//            }
//        }
//        return true;
