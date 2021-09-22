import java.util.Scanner;
/**
 * Class for objects like apples
 **/
public class MyObject {
    //Declaring Attributes for the objects...
    private String name;

    //Constructor
    public MyObject(String name){
        this.name = name;
    }

    //Getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
