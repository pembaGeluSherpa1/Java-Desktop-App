package IteratorEg;

public class People {
    String name;
    int age;
    People(String name, int age){
        this.name=name;
        this.age = age;
    }

    @Override
    public String toString(){
        return name+"("+age+")";
    }
}
