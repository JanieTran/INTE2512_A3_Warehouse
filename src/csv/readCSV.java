package csv;

import supportClass.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readCSV {
    //delimiter used in CSV file
    private static final String SEMICOLON = ";";

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
    }

    public static void main(String[] args) {
        readCSV("data.csv");
    }

}
