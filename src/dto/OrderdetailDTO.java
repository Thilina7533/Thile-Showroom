package dto;

public class OrderdetailDTO {
    private String orderID;
    private String itemCode;
    private Integer orderQTY;
    private Double unitPrice;


    public OrderdetailDTO(String orderID, String itemCode, Integer orderQTY, Double unitPrice) {
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

    public Integer getOrderQTY() {
        return orderQTY;
    }

    public void setOrderQTY(Integer orderQTY) {
        this.orderQTY = orderQTY;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
