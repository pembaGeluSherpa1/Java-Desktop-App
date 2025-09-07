package FileHandlingEg;

import java.io.FileWriter;
import java.io.IOException;

public class FileEg {
    public static void main(String[] args) {
        try{
            FileWriter writer = new FileWriter("./FileHandlingEg/demo.txt");
            writer.write("Pemba is my name and i love apple");
            writer.close();
            System.out.println("File created successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the file: " + e.getMessage());
        }
    }
}
