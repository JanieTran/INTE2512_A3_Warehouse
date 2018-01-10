package supportClass;

import java.util.Date;

public class Product {
    //--------------------Constant--------------------
    public static final String[] PRODUCT_LABEL = {"ID", "Name", "Quantity", "Description", "Producer",
            "Location", "Status", "Input Date", "Output Date"};
    public static final String[] PRODUCT_PROPERTIES = {"id", "name", "qty", "desc", "producer",
            "location", "status", "inputDate", "outputDate"};
    public static final int TOTAL_ATTRIBUTES = PRODUCT_LABEL.length;

    public static final int ID_INDEX = 0;
    public static final int NAME_INDEX = 1;
    public static final int QTY_INDEX = 2;
    public static final int DESC_INDEX = 3;
    public static final int PRODUCER_INDEX = 4;
    public static final int LOCATION_INDEX = 5;
    public static final int STATUS_INDEX = 6;
    public static final int INPUTDATE_INDEX = 7;
    public static final int OUTPUDATE_INDEX = 8;




    //--------------------Product Properties--------------------
    private String name;
    private String id;
    private int qty;
    private String desc;
    private String producer;
    private String location;
    private String status;
    private Date inputDate;
    private Date outputDate;

    public Product() {
        this.name = "unknown";
        this.id = "unknown";
        this.qty = 0;
        this.desc = "no description";
        this.producer = "unknown";
        this.location = "unknown";
        this.status = "unknown";
        this.inputDate = null;
        this.outputDate = null;
    }

    public Product(String name, String id, int qty) {
        this.name = name;
        this.id = id;
        this.qty = qty;
    }

    //set and get parameters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(Date outputDate) {
        this.outputDate = outputDate;
    }

}
