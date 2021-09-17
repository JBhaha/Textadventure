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

    //main method
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

}
