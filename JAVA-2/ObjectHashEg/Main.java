package ObjectHashEg;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Students> std= new  HashSet<>(); 

        std.add(new Students("pemba", 12));
        std.add(new Students("Ram", 22));
        std.add(new Students("Shyam", 32));
        std.add(new Students("Shyam", 32));
        System.out.println(std);
    }
}
