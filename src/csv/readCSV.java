/*
  RMIT University Vietnam
  Course: INTE2512 Object-Oriented Programming
  Semester: 2017C
  Assignment: 3 - Warehouse Management Application

  Authors:
    - Nguyen Tan Thanh          s3580014
    - Tran le Nha Tran          s3533562
    - Tran Thi Hong Phuong      s3623385

  Created date: 04/01/2018

  Description: This app gives the overview and statistics of a warehouse so that
  the manager can monitor and control the delivery of packages inside that warehouse.

  Acknowledgement:
  - https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG
  - https://stackoverflow.com/

*/

package csv;

import supportClass.Product;

import supportClass.Notifications;
import supportClass.Order;
import supportClass.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static supportClass.Product.*;
import static supportClass.Product.INPUTDATE_INDEX;
import static supportClass.Product.OUTPUTDATE_INDEX;

public class readCSV {
    //delimiter used in CSV file
    private static final String COMMA = ",";
    private static final String FILE_HEADER = "id,name,qty,desc,producer,location,status,inputDate,outputDate";

    //read csv from "product.csv"
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
                product.setImage(elements[IMAGE_INDEX]);
                products.add(product);
            }
        } catch (Exception e) {
            System.out.println("Error in CSV reader");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }
        return products;
    }

    //count the item in a csv file
    public static int count(String fileName) {
        int count = 0;
        BufferedReader fileReader = null;
        String line = "";
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null){
                count += 1;
            }
        } catch (Exception e) {
            System.out.println("Error in CSV reader");
        }
        return count;
    }

    //read csv from "notifications.csv"
    public static ArrayList<Notifications> readCSV_notifications(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Notifications> notifications = new ArrayList<>();

        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(COMMA);
                notifications.add(new Notifications(elements[0], elements[1]));
            }
        } catch (Exception e) {
            System.out.println("Error in CSV reader");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }
        return notifications;
    }

    //read csv file from "orders.csv"
    public static ArrayList<Order> readCSV_order(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Order> orders = new ArrayList<>();

        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(COMMA);
                orders.add(new Order(elements[0], elements[1], Integer.parseInt(elements[2]),
                        elements[3], elements[4]));
            }
        } catch (Exception e) {
            System.out.println("Error in CSV reader");
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

    //read data from as "input" status
    public static ArrayList<Order> readCSV_receiver(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Order> receiver = new ArrayList<>();

        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(COMMA);
                //receiver input
                if(elements[6].equals("input"))
                    receiver.add(new Order(elements[0], Integer.parseInt(elements[2])));
            }
        } catch (Exception e) {
            System.out.println("Error in CSV reader");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }
        return receiver;
    }

    //read data from as "output" status
    public static ArrayList<Order> readCSV_deliver(String fileName) {
        BufferedReader fileReader = null;
        ArrayList<Order> deliver = new ArrayList<>();

        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(COMMA);
                //deliver output
                if (elements[6].equals("output")) {
                    deliver.add(new Order(elements[0], Integer.parseInt(elements[2])));
                }
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
        return deliver;
    }

    public static ArrayList<User> readCSVtoUser (String fileName) {
        BufferedReader fileReader = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                String[] elements = line.split(COMMA);
                users.add(new User(elements[0], elements[1]));
            }
        } catch (Exception e) {
            System.out.println("Error in CSV reader");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader");
                e.printStackTrace();
            }
        }
        return users;
    }
}