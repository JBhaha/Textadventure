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

    //attributes for the cave
    private final String caveText = "Rocks and diamonds! A cave.";
    private final Place cave = new Place(0, "Cave", caveText);

    //attributes for the desert
    private final String desertText = "Sand everywhere! I guess we're in a desert!";
    private final Place desert = new Place(0, "Desert", desertText);

    //attributes for the island
    private final String islandText = "This is an island lol";
    private final Place island = new Place(0, "Island", islandText);

    //attributes for the town
    private final String townText = "You've reached the town";
    private final Place town = new Place(0, "Town", townText);

    //attributes for the tavern
    private final String tavernText = "Wow, here are many drunk people!";
    private final Place tavern = new Place(0, "Tavern", tavernText);

    //TODO: 3 more places between the desert and the town (mirage)

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

        //accessible places from the house
        house.addAccessiblePlaces(garden);

        //accessible places from the garden
        garden.addAccessiblePlaces(house);
        garden.addAccessiblePlaces(path);

        //accessible places from the path
        path.addAccessiblePlaces(garden);
        path.addAccessiblePlaces(clearing);

        //accessible places from the clearing
        clearing.addAccessiblePlaces(path);
        clearing.addAccessiblePlaces(branch);

        //accessible places from the branch
        branch.addAccessiblePlaces(clearing);
        branch.addAccessiblePlaces(cabin);
        branch.addAccessiblePlaces(camp);

        //accessible places from the cabin
        cabin.addAccessiblePlaces(branch);

        //accessible places from the camp
        camp.addAccessiblePlaces(branch);
        camp.addAccessiblePlaces(lake);

        //accessible places from the lake
        lake.addAccessiblePlaces(camp);
        lake.addAccessiblePlaces(river);
        lake.addAccessiblePlaces(island);

        //accessible places from the island
        island.addAccessiblePlaces(lake);
        island.addAccessiblePlaces(town);

        //accessible places from the town
        town.addAccessiblePlaces(island);
        town.addAccessiblePlaces(tavern);

        //accessible places from the tavern
        tavern.addAccessiblePlaces(town);

        //accessible places from the river
        river.addAccessiblePlaces(lake);
        river.addAccessiblePlaces(dunes);
        river.addAccessiblePlaces(cave);

        //accessible places from the cave
        cave.addAccessiblePlaces(river);
        cave.addAccessiblePlaces(desert);

        //accessible places from the dunes
        dunes.addAccessiblePlaces(river);
        dunes.addAccessiblePlaces(desert);

        //accessible places from the desert
        desert.addAccessiblePlaces(dunes);
        desert.addAccessiblePlaces(cave);



        //Wizard Arrays
        String[] wizardOptions = new String[3];
        String[] wizardAnswers = new String[3];

        //Ghostlady Arrays
        String[] ghostladyOptiones = new String[3];
        String[] ghostladyAnswers = new String[3];

        //fill wizard options array
        wizardOptions[0] = "Hello, I'm " + adventurer.getName();
        wizardOptions[1] = "What are you doing here?";
        wizardOptions[2] = "Bye!";

        //fill ghostlady options array
        ghostladyOptiones[0] = "Grüezi";
        ghostladyOptiones[1] = "Grüezi";
        ghostladyOptiones[2] = "Grüezi";

        //fill wizard answers array
        wizardAnswers[0] = "Hiiiiii";
        wizardAnswers[1] = "I'm just getting some shrooms *heheheheh*";
        wizardAnswers[2] = "Bye *hehehehe* bye";

        //fill ghostlady answers array
        ghostladyAnswers[0] = "Grüezi";
        ghostladyAnswers[1] = "Grüezi";
        ghostladyAnswers[2] = "Grüezi";

        //create creatures
        Creature wizard = new Creature("Magicman", "Hello! I'm the wizard, but everyone calls me MAGICMAN *heheh* and who are you?", wizardOptions, wizardAnswers);
        Creature ghostlady = new Creature("Ghostlady", "Ich grüsse Sie.", ghostladyOptiones, ghostladyAnswers);

        //add creatures to place
        clearing.addCreatures(wizard);
        cabin.addCreatures(ghostlady);
    }

    //Start method of the Textadventure!
    public void start(){
        house.placeLogic(adventurer);
    }

}
