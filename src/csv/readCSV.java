package csv;

import supportClass.Notifications;
import supportClass.Order;
import supportClass.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readCSV {
    //delimiter used in CSV file
    private static final String SEMICOLON = ";";
    private static final String COMMA = ",";

//    public static String[] elements;

    //read csv file functions
    public static void readCSV(String fileName) {
        BufferedReader fileReader = null;

        try {
            //create a new list of products to be filled by CSV file data
            ArrayList<Product> products = new ArrayList<>();

            String line = "";

            //create a file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //read the CSV header (1st line) and skip it
            fileReader.readLine();

            System.out.println("testing");
            while ((line = fileReader.readLine()) != null) {
                //split by semicolon
                String[] elements = line.split(SEMICOLON);
                for (int i = 0; i < elements.length; i++) {
                    System.out.println("The element is: " + elements[i]);
                }
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

        return orders;
    }

    public static void main(String[] args) {
//        readCSV("data.csv");
//        readCSVtoNotifications("src/database/notifications.csv");
//        readCSVtoOrder("src/database/orders.csv");
    }

}
