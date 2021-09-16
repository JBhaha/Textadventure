import java.util.Scanner;
/**
 * Class for backpacks (maybe selectable)
 **/
public class Backpack {
    private int space;

    //Constructor
    public Backpack(int space){
        this.space = space;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }
}
