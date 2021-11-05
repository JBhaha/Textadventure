import org.apache.commons.lang3.ArrayUtils;
/**
 * Class for the places
 **/

public class Place {

    //attributes for the class
    public Input inputReader = new Input();
    private String text;
    private String name;
    private int maxSpace;
    private int count;
    private int optionCntr = 1;
    private MyObject[] placeObjects;
    private Place[] accessiblePlaces = new Place[4];
    private int acsPlcsCntr = 0;
    private Creature[] creatures;
    private int creaturesCntr;

    //Constructor
    public Place(int maxSpace, String name, String text) {
        this.maxSpace = maxSpace;
        this.name = name;
        count = 0;
        placeObjects = new MyObject[maxSpace];
        this.text = text;
        creatures = new Creature[5];
        creaturesCntr = 0;
    }

    //Logic for the place and
    public void placeLogic(Adventurer adventurer){
        showPlace();
        setOptionCntr(1);
        int input = showOptions(optionCntr);
        selection(input, adventurer, optionCntr);
    }

    //Adds a dropped Object to the array of the place
    public void addObjectsToPlace(MyObject theObject) {
        placeObjects[count] = theObject;
        count++;
    }

    //prints out the objects in the place
    public void printObjects(){
        if (getCount() > 0) {
            System.out.println("In this place is:");
            for (int i = 0; i < getCount(); i++) {
                System.out.println("- " + placeObjects[i].getName());
            }
        }
    }


    public void droppItem(MyObject myObject){
        getPlaceObjects()[getCount()] = myObject;
        count++;
    }

    //show the text for the place & opens the method for printing the objects
    public void showPlace(){
        System.out.println(text);
        printObjects();
    }

    //show the objects which are in the place
    public int hereIs(int counter){
        int c = counter;
        for (int i = counter; i < count + counter; i++) {
            System.out.println("Option " + i + ": Take " + placeObjects[i-counter].getName());
            c++;
        }
        counter = c - 1;
        setOptionCntr(counter);
        if (creaturesCntr != 0){
            creaturesHere();
        }
        int input = inputReader.readInt();
        return input;
    }

    //Method for showing the options to talking to the creatures
    public void creaturesHere(){
        for (int i = 0; i < creaturesCntr; i++) {
            optionCntr++;
            System.out.println("Option " + optionCntr + ": " + "talk to " + creatures[i].getName());
        }
    }


    //Method for the selection by the user
    private void selection(int input, Adventurer adventurer, int counter){
        if ((input >= acsPlcsCntr + 1 && input <= counter)|| input == 0){
            if (creatures[0] == null || input <= counter - creaturesCntr) {
                objectSelection(input, adventurer);
            }else{
                creatures[input - (counter - creaturesCntr) - 1].talkTo();
                placeLogic(adventurer);
            }
        }else if (input > 0 && input <= acsPlcsCntr){
            accessiblePlaces[input-1].placeLogic(adventurer);
        }else{
            System.out.println("Invalid");
            placeLogic(adventurer);
        }
    }

    //Method to avoid redundance
    public void objectSelection(int input, Adventurer adventurer){
        if (input > acsPlcsCntr && input <= optionCntr) {
            adventurer.getBackpack().fillBackpack(placeObjects[input - acsPlcsCntr - 1]);
            placeObjects = ArrayUtils.remove(placeObjects, input - acsPlcsCntr - 1);
            count--; //lowers the counter for the array: placeObjects
            adventurer.getBackpack().showInventory();
        }
        else if(input == 0){
            MyObject myObj = adventurer.getBackpack().inventory();
            if (myObj != null) {
                droppItem(myObj);
            }else{
                placeLogic(adventurer);
            }
        }
        else{
            System.out.println("Invalid");
        }
        placeLogic(adventurer);
    }


    //Show options to do in the place
    public int showOptions(int counter){
        System.out.println("Opiton 0: Backpack");
        for (int i = 0; i < acsPlcsCntr; i++) {
            System.out.println("Option " + counter + ": " + accessiblePlaces[i].getName());
            counter++;
        }

        return hereIs(counter);
    }

    //Method for errors because of the user
    public void error(){
        System.out.println("Sorry! You're input was invalid. Please check your Input!");
    }


    public int getMaxSpace(){
        return maxSpace;

    }

    public void setMaxSpace(int maxSpace) {
        this.maxSpace = maxSpace;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyObject[] getPlaceObjects() {
        return placeObjects;
    }

    public void setPlaceObjects(MyObject[] placeObjects) {
        this.placeObjects = placeObjects;
    }

    public int getOptionCntr() {
        return optionCntr;
    }

    public void setOptionCntr(int optionCntr) {
        this.optionCntr = optionCntr;
    }

    public void addAccessiblePlaces(Place place){
        accessiblePlaces[acsPlcsCntr] = place;
        acsPlcsCntr++;
    }

    public void addCreatures(Creature creature) {
        if (creaturesCntr < 5){
            creatures[creaturesCntr] = creature;
            creaturesCntr++;
        }
    }
}