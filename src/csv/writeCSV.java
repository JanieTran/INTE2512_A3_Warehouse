package csv;

import supportClass.Order;
import supportClass.Product;
import java.io.*;
import java.util.ArrayList;

import static GUI.TabStatistics.ORDER_DATA_DIR;

public class writeCSV {
    //delimiter used in CSV file
    private static final String SEMICOLON = ",";
    private static final String NEW_LINE = "\n";

    public static void writeDataProduct(String fileName, Product product){
        ArrayList<Product> products = new ArrayList();
        products.add(product);

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            //write product info into csv file
            fileWriter.append(product.getName());
            fileWriter.append(SEMICOLON);
            fileWriter.append(product.getId());
            fileWriter.append(SEMICOLON);
            fileWriter.append(String.valueOf(product.getQty()));
            fileWriter.append(SEMICOLON);
            fileWriter.append(product.getDesc());
            fileWriter.append(SEMICOLON);
            fileWriter.append(product.getProducer());
            fileWriter.append(SEMICOLON);
            fileWriter.append(product.getLocation());
            fileWriter.append(SEMICOLON);
            fileWriter.append(product.getStatus());
            fileWriter.append(SEMICOLON);
            fileWriter.append(String.valueOf(product.getInputDate()));
            fileWriter.append(SEMICOLON);
            fileWriter.append(String.valueOf(product.getOutputDate()));

            System.out.println("CSV writes successfully");
        } catch (Exception e){
            System.out.println("Error in writing CSV file");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e){
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
    }

    public static void writeDataOrder(String fileName, Order order){
        ArrayList<Order> orders = readCSV.readCSVvtoOrder(ORDER_DATA_DIR);
        orders.add(order);

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName, true);
            //write product info into csv file
            fileWriter.append(order.getId());
            fileWriter.append(SEMICOLON);
            fileWriter.append(order.getName());
            fileWriter.append(SEMICOLON);
            fileWriter.append(String.valueOf(order.getQty()));
            fileWriter.append(SEMICOLON);
            fileWriter.append(order.getDesc());
            fileWriter.append(SEMICOLON);
            fileWriter.append(order.getProducer());
            fileWriter.append(SEMICOLON);
            fileWriter.append(order.getLocation());
            fileWriter.append(SEMICOLON);
            fileWriter.append(order.getStatus());
            fileWriter.append(SEMICOLON);
            fileWriter.append(String.valueOf(order.getInputDate()));
            fileWriter.append(SEMICOLON);
            fileWriter.append(String.valueOf(order.getOutputDate()));

            System.out.println("CSV writes successfully");
        } catch (Exception e){
            System.out.println("Error in writing CSV file");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e){
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
    }
}
