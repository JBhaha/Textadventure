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
    private final String pathText = "You're walking on the path. Suddenly, the path has a dead end.\n" +
            "Behind you, there's the path back to the garden.";
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
        house.placeLogic(places, 0, adventurer);
    }

}
