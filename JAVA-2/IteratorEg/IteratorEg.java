package IteratorEg;

import java.util.*;

public class IteratorEg {

    public static void main(String[] args) {
        HashMap<Integer,String> items = new HashMap<>();
        items.put(1,"Pemba");
        items.put(2,"hello");
        items.put(3,"its ");
        items.put(4,"me");
        items.put(5,"pemba");

        // Iterator<Map.Entry<Integer,String>> iterator = items.entrySet().iterator();

        // while(iterator.hasNext()){
        //     Map.Entry<Integer,String> entry = iterator.next();
        //     if(entry.getValue().equals("hello")){
        //         iterator.remove();
        //     }
        //     System.out.println("the item is "+entry);
        // }

        // System.out.println("************************************************");
        // for(Map.Entry<Integer,String> entry: items.entrySet()){
        //     System.out.println("the item is "+entry);
        // }

        List<People> peoples = new ArrayList<>();
        peoples.add(new People("Pemba",20));
        peoples.add(new People("Ram",12));
        peoples.add(new People("Shyam",21));
        peoples.add(new People("Hari",26));

        Collections.sort(peoples, new Comparator<People>() {
            
            @Override
            public int compare(People s1, People s2){
                // return s1.name.compareTo(s2.name);  // String sorting
                // return Integer.compare(s1.name.length(),s2.name.length()); // String length compare
                // return Integer.compare(s1.age,s2.age); // compare the age 
            }
        });
        System.out.println("Natural Sorted: "+peoples);
    }
}