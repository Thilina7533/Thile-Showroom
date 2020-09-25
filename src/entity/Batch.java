package entity;

public class Batch {
    private String BatchID;
    private String itemCode;

    public String getBatchID() {
        return BatchID;
    }

    public void setBatchID(String batchID) {
        BatchID = batchID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Batch() {
    }

    public Batch(String batchID, String itemCode) {
        BatchID = batchID;
        this.itemCode = itemCode;
    }
}
