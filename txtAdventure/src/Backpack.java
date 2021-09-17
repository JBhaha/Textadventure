import java.util.Scanner;
/**
 * Class for backpacks (maybe selectable)
 **/
public class Backpack {
    //Declaring Attributes for the backpacks...
    static Scanner scanner;
    private static Object returnObject;//This Object is vor the method inventory() do not touch! xD
    private int space;
    private static int used = 0;
    private static Object[] inventory;

    //Constructor
    public Backpack(int space){
        this.scanner = new Scanner(System.in);
        this.space = space;
        inventory = new Object[space];
    }

    //Method for putting things in the backpack
    public void fillBackpack(Object object){
        inventory[used] = object;
        used++;
    }

    //Method for the options in your Inventory
    public Object inventory(){
        System.out.println("Bitte wähle Option:");
        for (int i = 1; i < used + 1; i++) {
            System.out.println(i +": Drop " +  inventory[i-1].getName());
        }
        System.out.println("Press any number to close inventory.");
        int input = scanner.nextInt();
        for (int j = 0; j < used; j++) {
            if (input == j+1){
                returnObject = inventory[j];
                emptyBackpack(inventory[j]);
            }
        }
        return returnObject;
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

    public static int getUsed() { return used; }

    public static void setUsed(int used) { Backpack.used = used; }
}
