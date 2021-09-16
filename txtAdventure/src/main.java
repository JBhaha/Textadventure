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
    static Adventurer alex = new Adventurer("Alex", 20, 1);
    static Backpack defaultBackpack = new Backpack(20);


    //main method
    public static void main(String[] args) {

        alex.setBackpack(defaultBackpack);
        alex.getBackpack().fillBackpack(rope);
        alex.getBackpack().fillBackpack(sword);
        alex.getBackpack().showInventory();
    }

}
