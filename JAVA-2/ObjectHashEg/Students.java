package ObjectHashEg;

import java.util.Objects;

public class Students {
    String name;
    int id;

    // Constructor
    public Students(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Override hashCode() to ensure uniqueness in HashSet
    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    // Override equals() to compare based on name and id
    @Override
    public boolean equals(Object obj) {
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Students other = (Students) obj;
    
        // Compare relevant fields
        return this.id == other.id && this.name.equals(other.name);
    } 


    // Override toString() for better output
    @Override
    public String toString() {
        return "Students{name='" + name + "', id=" + id + "}";
    }
}