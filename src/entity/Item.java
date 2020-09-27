package entity;

public class Item {
    private String itemCode;
    private String suplayerID;
    private String Description;
    private String packSize;
    private String unitPrice;
    private String QtyOnHand;
    private String BatchID;

    public Item(String itemCode, String suplayerID, String description, String packSize, String unitPrice, String qtyOnHand, String batchID) {
        this.itemCode = itemCode;
        this.suplayerID = suplayerID;
        Description = description;
        this.packSize = packSize;
        this.unitPrice = unitPrice;
        QtyOnHand = qtyOnHand;
        BatchID = batchID;
    }

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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(String qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }

    public String getBatchID() {
        return BatchID;
    }

    public void setBatchID(String batchID) {
        BatchID = batchID;
    }
}
