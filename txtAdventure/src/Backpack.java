import java.util.Arrays;

/**
 * Class for backpacks (maybe selectable)
 **/
public class Backpack {
    //Declaring Attributes for the backpacks...
    private int space;
    private static int used = 0;
    private static Object[] inventory;

    //Constructor
    public Backpack(int space){
        this.space = space;
        inventory = new Object[space];
    }

    //Method for putting things in the backpack
    public void fillBackpack(Object object){
        inventory[used] = object;
        used++;
    }

    //Method for dropping things from the backpack
    public void emptyBackpack(Object object){
        String name = object.getName();
        for (int i = 0; i < used; i++) {
            if (inventory[i].getName().equals(name)){
                inventory[i] = null;
                used--;
            }
        }
    }

    //Method for printing inventory out
    public void showInventory(){
        System.out.println("You have: ");
        for (int i = 0; i < used; i++) {
            System.out.println("- " +  inventory[i].getName());
        }
    }

    //Getter and setter
    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }
}
