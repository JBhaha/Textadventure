import java.util.Scanner;
/**
 * Class for backpacks (maybe selectable)
 **/
public class Backpack {
    //Declaring Attributes for the backpacks...
    private int space;

    //Constructor
    public Backpack(int space){
        this.space = space;
    }

    //Getter and setter
    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }
}
