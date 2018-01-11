package csv;

import supportClass.Product;
import java.io.*;
import java.util.ArrayList;

public class writeCSV {
    //delimiter used in CSV file
    private static final String SEMICOLON = ",";
    private static final String NEW_LINE = "\n";

    public static void writeData (String fileName, Product product){
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
}
