import java.util.Scanner;
/**
 * Game logic (This is the good stuff)
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

    //attributes for the clearing
    private final String clearingText = "You get to the clearing. The warm sunshine is blinding you. \n" +
            "As you're trying to glance at the sun, you notice a weird-looking man next to you.";
    private final Place clearing = new Place(5, "Clearing", clearingText);

    //attributes for the branch
    private final String branchText = "You're standing on a Branch. There are three paths.";
    private final Place branch = new Place(0, "Branch", branchText);

    //attributes for the cabin
    private final String cabinText = "You're in a cabin. It's cold and spooky.";
    private final Place cabin = new Place(5, "Cabin", cabinText);

    //attributes for the camp
    private final String campText = "This is a camp";
    private final Place camp = new Place(5, "Camp", campText);

    //attributes for the lake
    private final String lakeText = "This is a lake";
    private final Place lake = new Place(0, "Lake", lakeText);

    //attributes for the river
    private final String riverText = "This is a river";
    private final Place river = new Place(0, "River", riverText);

    //attributes for the dunes
    private final String dunesText = "Those are some huge dunes";
    private final Place dunes = new Place(0, "Dunes", dunesText);

    //TODO: Add a place next to the dunes

    //attributes for the desert
    private final String desertText = "Sand everywhere! I guess we're in a desert!";
    private final Place desert = new Place(0, "Desert", desertText);

    //attributes for the island
    private final String islandText = "This is an island lol";
    private final Place island = new Place(0, "Island", islandText);

    //attributes for the town
    private final String townText = "You've reached the town";
    private final Place town = new Place(0, "Town", townText);

    //TODO: 4 more places between the desert and the town

    //Last places

    //attributes for the mountain
    private final String mountainText = "Woah! You can see everything from the top of this mountain!";
    private final Place mountain = new Place(0, "Mountain", mountainText);

    //attributes for the temple
    private final String templeText = "It's so dark in here...this temple is really spooky";
    private final Place temple = new Place(0, "temple", templeText);

    //attributes for the graveyard
    private final String graveyardText = "Soooo...Graveyard.";
    private final Place graveyard = new Place(0, "Graveyard", graveyardText);

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
        clearing.addAccessiblePlaces(branch);

        branch.addAccessiblePlaces(clearing);
        branch.addAccessiblePlaces(cabin);
        branch.addAccessiblePlaces(camp);

        cabin.addAccessiblePlaces(branch);

        camp.addAccessiblePlaces(branch);
        camp.addAccessiblePlaces(lake);

        lake.addAccessiblePlaces(camp);
        lake.addAccessiblePlaces(river);

        river.addAccessiblePlaces(lake);

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
