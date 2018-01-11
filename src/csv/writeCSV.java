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
import java.io.*;
import java.util.ArrayList;

public class writeCSV {
    //delimiter used in CSV file
    private static final String SEMICOLON = ",";

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
}
