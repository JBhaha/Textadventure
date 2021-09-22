import java.util.Scanner;
/**
 * Class for places
 **/
public class Game {
    static Scanner scanner;
    static int space = 5;

    //attributes for the house
    static int houseSpace = 0;
    static MyObject[] houseMyObjects = new MyObject[space];

    //attributes for the garden
    static int gardenSpace = 0;
    static MyObject[] gardenMyObjects = new MyObject[space];

    //attributes for the adventurer
    Adventurer alex = new Adventurer("Alex", 40, 50, 1);
    Backpack defaultBackpack = new Backpack(20);

    //Constructor
    public Game(){
        scanner = new Scanner(System.in);
        alex.setBackpack(defaultBackpack);

        //objects which are in the house at the beginning
        houseMyObjects[0] = new MyObject("rope");
        houseSpace++;
        houseMyObjects[1] = new MyObject("sword");
        houseSpace++;
        houseMyObjects[2] =  new MyObject("apple");
        houseSpace++;

        //objects which are in the garden at the beginning
        gardenMyObjects[0] = new MyObject("shovel");
        gardenSpace++;

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
                System.out.println("- " + houseMyObjects[i].getName());
            }
        }
        int counter = 0;
        System.out.println("Please select a number: ");
        System.out.println("Option " + counter + ": Go through the door.");
        counter++;
        int input = hereIs(houseSpace, houseMyObjects, counter);
        if (input == 0){
            garden();
        }else if (input > 0 && input < 9){
            for (int i = 1; i < houseSpace + 1; i++) {
                if (input == i){
                    wantsObject(houseMyObjects, houseSpace, space, input);
                    houseSpace--;
                    alex.getBackpack().showInventory();
                    house();
                }
            }
        }else if (input == 9){
            MyObject myObject = alex.getBackpack().inventory();
            if (myObject != null) {
                houseMyObjects[houseSpace] = myObject;
                System.out.println(houseMyObjects[houseSpace].getName());
                houseSpace++;
            }
            house();
        }else{
            error();
            house();
        }

    }

    //outside starting house
    public void garden(){
        System.out.println("You're standing in the garden in front of the house where you woke up.\n" +
                "Theres a door into the house and a small path into the forest.");
        int counter = 0;
        System.out.println("Please select a number:");
        System.out.println("Option " + counter + ": Go through the door");
        counter++;
        //System.out.println("Option " + counter + ": Take the Path");
        //counter++;
        int input = hereIs(gardenSpace, gardenMyObjects, counter);
        if (input == 0){
            house();
        }else if (input > 0 && input < 9){
            for (int i = 1; i < gardenSpace + 1; i++) {
                if (input == i){
                    wantsObject(gardenMyObjects, gardenSpace, space, input);
                    alex.getBackpack().showInventory();
                    gardenSpace--;
                    garden();
                }
            }
        }else if (input == 9){
            MyObject myObject = alex.getBackpack().inventory();
            if (myObject != null) {
                gardenMyObjects[gardenSpace] = myObject;
                System.out.println(gardenMyObjects[gardenSpace].getName());
                gardenSpace++;
            }
            garden();
        }else{
            error();
            garden();
        }


    }

    //path in front of the garden
    public void path(){
        System.out.println("You're walking on the path. Suddently the path has a dead end.\n" +
                "Behind you, there's the path back to the garden.");
    }

    //Method for the Objects which are in the place
    public int hereIs(int placeSpace, MyObject[] placeMyObjects, int count){
        for (int j = count; j < placeSpace + count; j++) {
            System.out.println("Option " + j + ": Take " + placeMyObjects[j-count].getName());
        }
        System.out.println("Opiton 9: Inventory");
        int input = scanner.nextInt();

        //TODO: Überprüfung der eingabe

        return input;
    }

    //Method for errors because of the user
    public void error(){
        System.out.println("Sorry! You're input was invalid. Please check your Input!");
    }


    //check if user wants to take a object
    public void wantsObject(MyObject[] myObjects, int maxSpace, int space, int input){
        MyObject[] help = new MyObject[maxSpace];
        maxSpace++;
        for (int i = 1; i < maxSpace; i++) {
            if (input == i){
                alex.getBackpack().fillBackpack(myObjects[i-1]);
                help = emptyRoom(myObjects[i-1], myObjects, space);
                space--;
                if (space >= 0) System.arraycopy(help, 0, myObjects, 0, space);
                alex.getBackpack().showInventory();
            }
        }
    }

    //Method for taking something from the place
    public MyObject[] emptyRoom(MyObject myObject, MyObject placeMyObjects[], int placeSpace) {
        MyObject[] help = new MyObject[placeSpace];
        String name = myObject.getName();
        int i = 0;
        while (!placeMyObjects[i].getName().equals(name)) {
            help[i] = placeMyObjects[i];
            placeMyObjects[i] = null;
            i++;
        }
        placeMyObjects[i] = null;
        for (int j = i + 1; j < placeSpace; j++) {
            help[j - 1] = placeMyObjects[j];
            placeMyObjects[j] = null;
        }
        placeSpace--;
        for (int j = 0; j < placeSpace; j++) {
            placeMyObjects[j] = help[j];
        }
        return placeMyObjects;
    }

}
