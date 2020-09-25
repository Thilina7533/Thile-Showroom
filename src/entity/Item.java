package entity;

public class Item {
    private String itemCode;
    private String suplayerID;
    private String Description;
    private String packSize;
    private Double unitPrice;
    private Integer QtyOnHand;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getSuplayerID() {
        return suplayerID;
    }

    public void setSuplayerID(String suplayerID) {
        this.suplayerID = suplayerID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(Integer qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }

    public Item() {
    }

    public Item(String itemCode, String suplayerID, String description, String packSize, Double unitPrice, Integer qtyOnHand) {
        this.itemCode = itemCode;
        this.suplayerID = suplayerID;
        Description = description;
        this.packSize = packSize;
        this.unitPrice = unitPrice;
        QtyOnHand = qtyOnHand;
    }
}
