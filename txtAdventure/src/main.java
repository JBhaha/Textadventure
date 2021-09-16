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

    public static void main(String[] args) {
        Adventurer alex = new Adventurer("Alex", 20, 1);
        Backpack defaultBackpack = new Backpack(20);
        Object rope = new Object("rope");
        alex.setBackpack(defaultBackpack);
        System.out.println(alex.getBackpack().getSpace());
    }

}
