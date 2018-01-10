package csv;

import supportClass.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class writeCSV {
    //delimiter used in CSV file
    private static final String SEMICOLON = ";";
    private static final String NEW_LINE = "\n";

    //CSV file header
    private static final String FILE_HEADER = "id;name;qty;desc;producer;location" +
            ";status;inputDate;outputDate";

    public static void writeData (String fileName, Product product){
        List products = new ArrayList();
        products.add(product);

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);

            //write CSV header file
            fileWriter.append(FILE_HEADER);
            //add new line seperator
            fileWriter.append(NEW_LINE);

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
            fileWriter.append(NEW_LINE);

            System.out.println("done");

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
