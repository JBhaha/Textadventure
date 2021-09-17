import java.util.Scanner;

/**
 * Small textadventure
 *
 * @author Philip, Hermann & Jakub
 * @since 16.09.2021
 * @version 1.0
 */

public class main {
    static Scanner scanner;

    public main(){
        scanner = new Scanner(System.in);
    }

    //Create Objects
    static Object rope = new Object("rope");
    static Object sword = new Object("sword");
    static Object apple = new Object("apple");
    static Adventurer alex = new Adventurer("Alex", 40, 50, 1);
    static Backpack defaultBackpack = new Backpack(20);


    //main method
    public static void main(String[] args) {
        alex.setBackpack(defaultBackpack);
        alex.getBackpack().fillBackpack(rope);
        alex.getBackpack().fillBackpack(sword);
        alex.getBackpack().fillBackpack(apple);
        alex.getBackpack().showInventory();
        alex.getBackpack().emptyBackpack(rope);
        alex.getBackpack().showInventory();
    }

}
