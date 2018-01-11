package supportClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public static final int OUTPUTDATE_INDEX = 8;
    public static final int IMAGE_INDEX = 9;

//    public static final int CURRENTINPUT_INDEX = 9;
//    public static final int CURRENTOUTPUT_INDEX = 10;


    //--------------------Product Properties--------------------
    private String name;
    private String id;
    private int qty;
    private String desc;
    private String producer;
    private String location;
    private String status;
    private String inputDate;
    private String outputDate;
    private int currentInput;
    private int currentOutput;
    private String image;

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

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
        this.currentInput = 0;
        this.currentOutput = 0;
        this.image = "";
    }

    public Product(String name, String id, int qty) {
        this.name = name;
        this.id = id;
        this.qty = qty;
    }

    public Product(String name, String id, int qty, String desc, String producer, String location,
                   String status, String inputDate, String outputDate,String image) {
        this.name = name;
        this.id = id;
        this.qty = qty;
        this.desc = desc;
        this.producer = producer;
        this.location = location;
        this.status = status;
        this.inputDate = inputDate;
        this.outputDate = outputDate;
        this.image = image;
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

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(String outputDate) {
        this.outputDate = outputDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCurrentInput() {
        return currentInput;
    }

    public void setCurrentInput(int currentInput) {
        this.currentInput = currentInput;
    }

    public int getCurrentOutput() {
        return currentOutput;
    }

    public void setCurrentOutput(int currentOutput) {
        this.currentOutput = currentOutput;
    }

}
