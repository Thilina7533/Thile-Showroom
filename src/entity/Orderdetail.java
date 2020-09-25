package entity;

public class Orderdetail {
    private String orderID;
    private String itemCode;
    private Integer orderQTY;
    private Double Discount;

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

    public Integer getOrderQTY() {
        return orderQTY;
    }

    public void setOrderQTY(Integer orderQTY) {
        this.orderQTY = orderQTY;
    }

    public Double getDiscount() {
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    public Orderdetail() {
    }

    public Orderdetail(String orderID, String itemCode, Integer orderQTY, Double discount) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.orderQTY = orderQTY;
        Discount = discount;
    }
}