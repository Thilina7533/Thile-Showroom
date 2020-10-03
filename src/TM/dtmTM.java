package TM;

public class dtmTM {
    String code;
    String name;
    String price;
    String QTY;

    public dtmTM(String code, String name, String price, String QTY) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.QTY = QTY;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQTY() {
        return QTY;
    }

    public void setQTY(String QTY) {
        this.QTY = QTY;
    }
}
