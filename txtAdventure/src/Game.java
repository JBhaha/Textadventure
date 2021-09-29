import java.util.Scanner;
/**
 * Class for places
 **/
public class Game {
    static Scanner scanner;
    private final Place[] places = new Place[3];

    //Make Objects
    MyObject rope = new MyObject("rope");
    MyObject sword = new MyObject("sword");
    MyObject apple = new MyObject("apple");
    MyObject shovel = new MyObject("shovel");

    //attributes for the house
    private final String houseText = "You're standing in a dark room. You can't remember how you got here.\n" +
            "You stand up. There's a door at the end of the room.";
    private final Place house = new Place(5, "house", houseText);

    //attributes for the garden
    private final String gardenText = "You're standing in the garden in front of the house where you woke up.\n" +
            "Theres a door into the house and a small path into the forest.";
    private final Place garden = new Place(5, "garden", gardenText);

    //attributes for the path
    private final String pathText = "Dead end";
    private final Place path = new Place(5, "path", pathText);


    //attributes for the adventurer
    Adventurer adventurer = new Adventurer("Alex", 40, 50, 1);
    Backpack defaultBackpack = new Backpack(20);

    //Constructor
    public Game(){
        scanner = new Scanner(System.in);
        adventurer.setBackpack(defaultBackpack);

        //objects which are in the house at the beginning
        house.addObjectsToPlace(rope);
        house.addObjectsToPlace(sword);
        house.addObjectsToPlace(apple);

        //objects which are in the garden at the beginning
        garden.addObjectsToPlace(shovel);

        //put places in array
        places[0] = house;
        places[1] = garden;
        places[2] = path;
    }   

    //Start method of the Textadventure!
    public void start(){
        System.out.println("Welcome to the Textadventure!\nWe hope you enjoy it. Let's get started!");
        house();
    }

    //Starting House
    public void house() {
        house.showPlace();
        house.printObjects();
        int counter = 1;
        int input = printOptions(0, counter, house);
        if (input == 1){
            garden();
        }else if (input > 1 && input < 9){
            for (int i = 2; i < house.getCount() + 2; i++) {
                if (input == i){
                    wantsObject(house.getPlaceObjects(), house.getCount(), house.getMaxSpace(), input-1);
                    house.setCount(house.getCount() - 1);
                    adventurer.getBackpack().showInventory();
                    house();
                }
            }
        }else if (input == 9){
            MyObject myObject = adventurer.getBackpack().inventory();
            if (myObject != null) {
                house.droppItem(myObject);
            }
            house();
        }else{
            error();
            house();
        }

    }

    //outside starting house
    public void garden(){
        garden.showPlace();
        int counter = 1;
        int input = printOptions(1,counter,garden);
        if (input == 1){
            house();
        }else if (input > 1 && input < 9){
            for (int i = 2; i < garden.getCount() + 2; i++) {
                if (input == i){
                    wantsObject(garden.getPlaceObjects(), garden.getCount(), garden.getMaxSpace(), input-1);
                    adventurer.getBackpack().showInventory();
                    garden.setCount(garden.getCount() - 1);
                    garden();
                }
            }
        }else if (input == 9){
            MyObject myObject = adventurer.getBackpack().inventory();
            if (myObject != null) {
                garden.droppItem(myObject);
            }
            garden();
        }else{
            error();
            garden();
        }


    }

    //path in front of the garden
    public void path(){
        System.out.println("You're walking on the path. Suddenly, the path has a dead end.\n" +
                "Behind you, there's the path back to the garden.");
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
                adventurer.getBackpack().fillBackpack(myObjects[i-1]);
                help = emptyRoom(myObjects[i-1], myObjects, space);
                space--;
                if (space >= 0) System.arraycopy(help, 0, myObjects, 0, space);
                adventurer.getBackpack().showInventory();
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
        if (placeSpace >= 0) System.arraycopy(help, 0, placeMyObjects, 0, placeSpace);
        return placeMyObjects;
    }


    //Method for printing out the places in front and in the back
    private int printOptions(int index, int counter, Place place){
        if (index != 0){
            if (index > 3){
                System.out.println("Option " + counter + ": " + places[index-1].getName());
                counter++;
                System.out.println("Option " + counter + ": " + places[index+1].getName());
                counter++;
                int input = place.hereIs(counter);
                return input;
            }else{
                System.out.println("Option " + counter + ": " + places[index-1].getName());
                counter++;
                int input = place.hereIs(counter);
                return input;
            }
        }else{
            System.out.println("Option " + counter + ": " + places[index+1].getName());
            counter++;
            int input = place.hereIs(counter);
            return input;
        }
    }

}
