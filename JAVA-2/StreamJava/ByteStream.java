package StreamJava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) {
        String data = "Hello, this is a byte stream example!";
        try {
            FileInputStream input = new FileInputStream("employee.csv");
            FileOutputStream output = new FileOutputStream("employee.csv");
            byte[] byteData = data.getBytes(); 
            System.out.println(input.read());
            output.write(byteData);
            input.close();
            output.close();
            System.out.println("Data written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
