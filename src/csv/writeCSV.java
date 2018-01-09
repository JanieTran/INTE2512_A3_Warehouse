package csv;

import product.Product;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class writeCSV {
    //delimiter used in CSV file
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";

    //CSV file header
    private static final String FILE_HEADER = "id,name,qty,desc,producer,location" +
            ",status,inputDate,outputDate";

    public static void writeData (String fileName, Product product){
        //parse object info
        List products = new ArrayList();
        products.add(product);

        PrintWriter fileWriter = null;

        try {
            fileWriter = new PrintWriter(fileName);
            StringBuilder stringBuilder = new StringBuilder();

            //write CSV header file
            fileWriter.append(FILE_HEADER);
            //add new line seperator
            fileWriter.append(NEW_LINE);

            //write product info into csv file
            fileWriter.append(product.getName());
            fileWriter.append(COMMA);
            fileWriter.append(product.getId());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(product.getQty()));
            fileWriter.append(COMMA);
            fileWriter.append(product.getDesc());
            fileWriter.append(COMMA);
            fileWriter.append(product.getProducer());
            fileWriter.append(COMMA);
            fileWriter.append(product.getLocation());
            fileWriter.append(COMMA);
            fileWriter.append(product.getStatus());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(product.getInputDate()));
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(product.getOutputDate()));
            fileWriter.append(COMMA);
            fileWriter.append(NEW_LINE);

            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
            System.out.println("done");

            System.out.println("CSV writes successfully");
        } catch (Exception e){
            System.out.println("Error in writing CSV file");
            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e){
//                System.out.println("Error while flushing/closing fileWriter");
//                e.printStackTrace();
//            }
        }
    }
}
