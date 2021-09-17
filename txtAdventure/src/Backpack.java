
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
        Object[] help = new Object[space];
        String name = object.getName();
        int i = 0;
        while (!inventory[i].getName().equals(name)){
            help[i] = inventory[i];
            inventory[i] = null;
            i++;
        }
        inventory[i] = null;
        for (int j = i + 1; j < used; j++) {
            help[j - 1] = inventory[j];
            inventory[j] = null;
        }
        used--;
        for (int j = 0; j < used; j++) {
            inventory[j] = help[j];
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
