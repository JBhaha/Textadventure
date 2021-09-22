import java.util.Scanner;
/**
 * Class for places
 **/
public class Game {
    static Scanner scanner;

    //Make Objects
    MyObject rope = new MyObject("rope");
    MyObject sword = new MyObject("sword");
    MyObject apple = new MyObject("apple");
    MyObject shovel = new MyObject("shovel");

    //attributes for the house
    private Place house = new Place(5, "house");

    //attributes for the garden
    private Place garden = new Place(5, "garden");

    //attributes for the adventurer
    Adventurer alex = new Adventurer("Alex", 40, 50, 1);
    Backpack defaultBackpack = new Backpack(20);

    //Constructor
    public Game(){
        scanner = new Scanner(System.in);
        alex.setBackpack(defaultBackpack);

        //objects which are in the house at the beginning
        house.addObjectsToPlace(rope);
        house.addObjectsToPlace(sword);
        house.addObjectsToPlace(apple);

        //objects which are in the garden at the beginning
        garden.addObjectsToPlace(shovel);
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
        house.printObjects();
        int counter = 0;
        System.out.println("Please select a number: ");
        System.out.println("Option " + counter + ": Go through the door.");
        counter++;
        int input = hereIs(house.getCount(), house.getPlaceObjects(), counter);
        if (input == 0){
            garden();
        }else if (input > 0 && input < 9){
            for (int i = 1; i < house.getCount() + 1; i++) {
                if (input == i){
                    wantsObject(house.getPlaceObjects(), house.getCount(), house.getMaxSpace(), input);
                    house.setCount(house.getCount() - 1);
                    alex.getBackpack().showInventory();
                    house();
                }
            }
        }else if (input == 9){
            MyObject myObject = alex.getBackpack().inventory();
            if (myObject != null) {
                house.getPlaceObjects()[house.getCount()] = myObject;
                System.out.println(house.getPlaceObjects()[house.getCount()].getName());
                house.setCount(house.getCount() - 1);
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
        int input = hereIs(garden.getCount(), garden.getPlaceObjects(), counter);
        if (input == 0){
            house();
        }else if (input > 0 && input < 9){
            for (int i = 1; i < garden.getCount() + 1; i++) {
                if (input == i){
                    wantsObject(garden.getPlaceObjects(), garden.getCount(), garden.getMaxSpace(), input);
                    alex.getBackpack().showInventory();
                    garden.setCount(garden.getCount() - 1);
                    garden();
                }
            }
        }else if (input == 9){
            MyObject myObject = alex.getBackpack().inventory();
            if (myObject != null) {
                garden.getPlaceObjects()[garden.getCount()] = myObject;
                System.out.println(garden.getPlaceObjects()[garden.getCount()].getName());
                garden.setCount(garden.getCount() - 1);
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
