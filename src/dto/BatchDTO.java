package dto;

public class BatchDTO {
    private String BatchID;
    private String itemCode;

    public BatchDTO(String batchID, String itemCode) {
        BatchID = batchID;
        this.itemCode = itemCode;
    }

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

    public BatchDTO() {
    }
}
