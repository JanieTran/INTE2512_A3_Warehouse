package product;

public class Product {
    private String name;
    private String id;
    private String qty;
    private String desc;
    private String producer;
    private String location;
    private String status;
    private String inputDate;
    private String outputDate;
    private String image;

    public Product() {
        this.name = "unknown";
        this.id = "unknown";
        this.qty = "0";
        this.desc = "no description";
        this.producer = "unknown";
        this.location = "unknown";
        this.status = "unknown";
        this.inputDate = null;
        this.outputDate = null;
        this.image = null;
    }

    public Product(String name, String id, String qty) {
        this.name = name;
        this.id = id;
        this.qty = qty;
    }

    public Product( String id,String name, String qty, String desc, String producer, String location, String status, String inputDate, String outputDate,String image) {
        this.id = id;
        this.name = name;
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

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
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

    @Override public String toString()
    { return "Book [id=" + id + ", name=" + name + ", quantity=" + qty + ", desc=" + desc +", producer=" + producer +", location=" + location +", status=" + status +", inputdate=" + inputDate +", outputdate=" + outputDate +" , image=" + image +"]"; }

}
