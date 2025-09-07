package Form;

public class FormData {
    private String name;
    private String surName;
    private String gender;
    private String international;
    private String country;

    FormData(String name,String surName, String gender, String international, String country){
        this.name = name;
        this.surName = surName;
        this.gender = gender;
        this.country = country;
        this.international = international;

        getter();
    }

    public String getter(){
        return name+" | "+ surName+" | "+gender+" | "+country;
    }

    // public void setter(String name){
    //     this.name = name;
    // }

}
