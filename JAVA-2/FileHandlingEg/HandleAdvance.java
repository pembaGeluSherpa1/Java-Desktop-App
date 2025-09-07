package FileHandlingEg;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HandleAdvance {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        
        try (FileWriter writer = new FileWriter("./FileHandlingEg/Content.txt", true)) {
            while (true) {
                System.out.println("Enter the message / Type exit to exit");
                String a = x.nextLine();

                if (a.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(a + "\n");
            }
            
            System.out.println("Written Successfully");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }finally {
            x.close(); 
        }

        try (FileReader reader = new FileReader("./FileHandlingEg/Content.txt")) {
            System.out.println("\nContents of the file:");
                System.out.print(reader);
        } catch (IOException e) {
            System.out.println("Error occurred while reading: " + e.getMessage());
        }
    }
}