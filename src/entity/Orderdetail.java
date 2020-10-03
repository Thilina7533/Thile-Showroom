package entity;

public class Orderdetail {
    private String orderID;
    private String itemCode;
    private String orderQTY;
    private String unitPrice;


    public Orderdetail(String orderID, String itemCode, String orderQTY, String unitPrice) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.orderQTY = orderQTY;
        this.unitPrice = unitPrice;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getOrderQTY() {
        return orderQTY;
    }

    public void setOrderQTY(String orderQTY) {
        this.orderQTY = orderQTY;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
