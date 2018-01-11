package csv;

import supportClass.Notifications;
import supportClass.Order;
import supportClass.Product;

import supportClass.Notifications;
import supportClass.Order;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static supportClass.Product.*;
import static supportClass.Product.INPUTDATE_INDEX;
import static supportClass.Product.OUTPUTDATE_INDEX;

public class readCSV {
    //delimiter used in CSV file
<<<<<<< HEAD
    private static final String SEMICOLON = ";";
    private static final String COMMA = ",";
=======
    private static final String COMMA = ",";
    private static final String FILE_HEADER = "id,name,qty,desc,producer,location,status,inputDate,outputDate";
>>>>>>> master

    public static int total_product = 0;

    //read csv file functions
    public static ArrayList<Product> readCSV_product(String fileName) {
        //create a new list of products to be filled by CSV file data
        ArrayList<Product> products = new ArrayList<>();
        Product product;

        BufferedReader fileReader = null;
        String line = "";

        try {
            //create a file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //read the CSV header (1st line) and skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {

                //split by semicolon
                String[] elements = line.split(COMMA);

                product = new Product();
                product.setId(elements[ID_INDEX]);
                product.setName(elements[NAME_INDEX]);
                product.setQty(Integer.parseInt(elements[QTY_INDEX]));
                product.setDesc(elements[DESC_INDEX]);
                product.setProducer(elements[PRODUCER_INDEX]);
                product.setLocation(elements[LOCATION_INDEX]);
                product.setStatus(elements[STATUS_INDEX]);
                product.setInputDate(elements[INPUTDATE_INDEX]);
                product.setOutputDate(elements[OUTPUTDATE_INDEX]);
                products.add(product);

                System.out.println("add sucessfully");
            }
        }

        catch (Exception e) {
            System.out.println("Error in CSVreader");
            e.printStackTrace();
        }

        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Notifications> readCSVtoNotifications(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Notifications> notifications = new ArrayList<>();

        try {
            String line = "";

            //create a file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //read the CSV header (1st line) and skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(COMMA);
                notifications.add(new Notifications(elements[0], elements[1]));
            }
        }

        catch (Exception e) {
            System.out.println("Error in CSVreader");
            e.printStackTrace();
        }

        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }

        return notifications;
    }

    public static ArrayList<Order> readCSVtoOrder(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Order> orders = new ArrayList<>();

        try {
            String line = "";

            //create a file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //read the CSV header (1st line) and skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(COMMA);
                orders.add(new Order(elements[0], elements[1], Integer.parseInt(elements[2]), elements[3], elements[4]));
            }
        }

        catch (Exception e) {
            System.out.println("Error in CSVreader");
            e.printStackTrace();
        }

        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }
<<<<<<< HEAD

        return orders;
    }

    public static void main(String[] args) {
//        readCSV("data.csv");
//        readCSVtoNotifications("src/database/notifications.csv");
//        readCSVtoOrder("src/database/orders.csv");
=======
        return products;
    }

    public static int count(String fileName) {
        int count = 0;

        BufferedReader fileReader = null;
        String line = "";

        try {
            //create a file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //read the CSV header (1st line) and skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null ||
                    (line = fileReader.readLine()) == FILE_HEADER) {
                count += 1;
            }
        } catch (Exception e) {
            System.out.println("Error in readCSV");
        }
        return count;
>>>>>>> master
    }

    public static ArrayList<Notifications> readCSVtoNotifications(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Notifications> notifications = new ArrayList<>();

        try {
            String line = "";

            //create a file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //read the CSV header (1st line) and skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(COMMA);
                notifications.add(new Notifications(elements[0], elements[1]));
            }
        }

        catch (Exception e) {
            System.out.println("Error in CSVreader");
            e.printStackTrace();
        }

        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }

        return notifications;
    }

    public static ArrayList<Order> readCSVtoOrder(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Order> orders = new ArrayList<>();

        try {
            String line = "";

            //create a file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //read the CSV header (1st line) and skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(COMMA);
                orders.add(new Order(elements[0], elements[1], Integer.parseInt(elements[2]), elements[3], elements[4]));
            }
        } catch (Exception e) {
            System.out.println("Error in CSVreader");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }

        return orders;
    }
}


