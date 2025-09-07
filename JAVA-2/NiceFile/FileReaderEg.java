package NiceFile;

import java.io.FileReader;
import java.util.ArrayList;

public class FileReaderEg {
    public static void main(String[] args) {
        String fileName = "employee.csv";

        try(FileReader content = new FileReader(fileName)){
            String data = "";
            int i;
            
            while((i = content.read()) != -1){
                char value = (char)i;
                data += value;
            }

            System.out.println(data);
        }catch(Exception e){
            System.out.println("File not found");
        }
    }
}