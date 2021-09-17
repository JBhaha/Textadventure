import java.util.Scanner;
/**
 * Class for places
 **/
public class Game {
    static Scanner scanner;
    static int space = 5;

    //attributes for the house
    static int houseSpace = 3;
    static Object[] houseObjects = new Object[space];

    //attributes for the adventurer
    Adventurer alex = new Adventurer("Alex", 40, 50, 1);
    static Backpack defaultBackpack = new Backpack(20);

    //Constructor
    public Game(){
        scanner = new Scanner(System.in);
        alex.setBackpack(defaultBackpack);

        //objects which are in the house at the beginning
        houseObjects[0] = new Object("rope");
        houseObjects[1] = new Object("sword");
        houseObjects[2] =  new Object("apple");
    }

    //Start method of the Textadventure!
    public void start(){
        System.out.println("Welcome to the Textadventure!\nWe hope you enjoy it. Let's get started!");
        house();
    }

    //Starting House
    public void house() {
        System.out.println("You're standing in a dark room. You can't remember how you got here.\n" +
                "You stand up. There's a door at the end of the room.");
        if (houseSpace >= 0) {
            System.out.println("On the Desk is:");
            for (int i = 0; i < houseSpace; i++) {
                System.out.println("- " + houseObjects[i].getName());
            }
        }
        System.out.println("Please select a number: ");
        System.out.println("Option 0: Go through the door.");
        for (int j = 1; j < houseSpace + 1; j++) {
            System.out.println("Option " + j + ": Take " + houseObjects[j-1].getName());
        }
        int input = scanner.nextInt();
        if (input == 0){
            garden();
        }else if (input > 0){
            for (int i = 1; i < houseSpace + 1; i++) {
                if (input == i){
                    wantsObject(houseObjects, houseSpace, space, input);
                    house();
                }
            }
        }else{
            error();
            house();
        }

    }

    //outside starting house
    public void garden(){
        System.out.println("You're standing in the garden in front of the house where you woke up.\n" +
                "Theres a door into the house and a small path into the forest.");

    }

    //path in front of the garden
    public void path(){
        System.out.println("You're walking on the path. Suddently the path has a dead end.\n" +
                "Behind you, there's the path back to the garden.");
    }



    //Method for errors because of the user
    public void error(){
        System.out.println("Sorry! You're input was invalid. Please check your Input!");
    }


    //check if user wants to take a object
    public void wantsObject(Object[] objects, int maxSpace, int space, int input){
        for (int i = 1; i < maxSpace + 1; i++) {
            if (input == i){
                alex.getBackpack().fillBackpack(objects[i-1]);
                emptyRoom(objects[i-1]);
                alex.getBackpack().showInventory();
            }
        }
    }

    //Method for taking something from the place
    public void emptyRoom(Object object){
        Object[] help = new Object[houseSpace];
        String name = object.getName();
        int i = 0;
        while (!houseObjects[i].getName().equals(name)){
            help[i] = houseObjects[i];
            houseObjects[i] = null;
            i++;
        }
        houseObjects[i] = null;
        for (int j = i + 1; j < houseSpace; j++) {
            help[j - 1] = houseObjects[j];
            houseObjects[j] = null;
        }
        houseSpace--;
        for (int j = 0; j < houseSpace; j++) {
            houseObjects[j] = help[j];
        }
    }

}
