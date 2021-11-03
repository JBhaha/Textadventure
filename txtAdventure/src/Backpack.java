/**
 * Class for backpacks (maybe selectable)
 **/
public class Backpack {
    //Declaring Attributes for the backpacks...
    static Input inputReader = new Input();
    private static MyObject returnMyObject;//This Object is f   or the method inventory() do not touch! xD
    private final int space;
    private static int used = 0;
    private static MyObject[] inventory;

    //Constructor
    public Backpack(int space){
        this.space = space;
        inventory = new MyObject[space];
    }

    //Method for putting things in the backpack
    public void fillBackpack(MyObject myObject){
        inventory[used] = myObject;
        used++;
    }

    //Method for the options in your Inventory
    public MyObject inventory(){
        if (used == 0){
            System.out.println("Your backpack is empty");
            System.out.println("0: Close backpack");
        }else {
            System.out.println("Choose Option:");
            System.out.println("0: Close backpack");
            for (int i = 1; i < used + 1; i++) {
                System.out.println(i + ": Drop " + inventory[i - 1].getName());
            }
        }
        int input = inputReader.readInt();
        for (int j = 0; j < used; j++) {
            if (input == j+1){
                returnMyObject = inventory[j];
                emptyBackpack(inventory[j]);
            }else if (input == 0){
                return null;
            }
        }
        return returnMyObject;
    }

    //Method for dropping things from the backpack
    public void emptyBackpack(MyObject myObject){

        MyObject[] help = new MyObject[space];
        String name = myObject.getName();
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
        if (used >= 0) System.arraycopy(help, 0, inventory, 0, used);
    }

    //Method for printing inventory out
    public void showInventory(){
        System.out.println("You have:");
        for (int i = 0; i < used; i++) {
            System.out.println("- " + inventory[i].getName());
        }
    }

}
