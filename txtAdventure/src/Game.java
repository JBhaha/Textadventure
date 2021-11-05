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
    private final String houseText = "You're standing in a dark room. You can't remember how you got here.\n" +
            "You stand up. There's a door at the end of the room.";
    private final Place house = new Place(5, "House", houseText);

    //attributes for the garden
    private final String gardenText = "You're standing in the garden in front of the house where you woke up.\n" +
            "Theres a door into the house and a small path into the forest.";
    private final Place garden = new Place(5, "Garden", gardenText);

    //attributes for the path
    private final String pathText = "You're standing on the Path. At the end of the Path, there is a clearing.";
    private final Place path = new Place(5, "Path", pathText);

    private final String clearingText = "This is a clearing :D";
    private final Place clearing = new Place(5, "Clearing", clearingText);
    //attributes for the adventurer
    Adventurer adventurer = new Adventurer("Alex", 40, 50, 1);
    Backpack defaultBackpack = new Backpack(20);

    //Constructor
    public Game(){
        Input input = new Input();
        System.out.println("Welcome to the Textadventure!\nWe hope you enjoy it. Let's get started!");
        System.out.print("What's you name?\n" +
                "> ");
        adventurer.setName(input.readString());
        scanner = new Scanner(System.in);
        adventurer.setBackpack(defaultBackpack);

        //objects which are in the house at the beginning
        house.addObjectsToPlace(rope);
        house.addObjectsToPlace(sword);
        house.addObjectsToPlace(apple);

        //objects which are in the garden at the beginning
        garden.addObjectsToPlace(shovel);
        house.addAccessiblePlaces(garden);
        garden.addAccessiblePlaces(house);
        garden.addAccessiblePlaces(path);
        path.addAccessiblePlaces(garden);
        path.addAccessiblePlaces(clearing);
        clearing.addAccessiblePlaces(path);

        //Creatures Arrays
        String[] wizardOptions = new String[3];
        String[] wizardAnswers = new String[3];

        //fill creature options array
        wizardOptions[0] = "Hello, I'm " + adventurer.getName();
        wizardOptions[1] = "What are you doing here?";
        wizardOptions[2] = "Bye!";

        //fill creature answers array
        wizardAnswers[0] = "Hello! I'm the wizard, but everyone calls me MAGICMAN *heheh* and who are you?";
        wizardAnswers[1] = "I'm getting some shrooms *heheheheh*";
        wizardAnswers[2] = "Bye *hehehehe* bye";

        //create creatures
        Creature wizard = new Creature("Magicman", "Hello my friend. My name is Magicman! How can I help you?!?!", wizardOptions, wizardAnswers);

        //add creatures to place
        clearing.addCreatures(wizard);
    }   

    //Start method of the Textadventure!
    public void start(){
        house.placeLogic(adventurer);
    }

}
