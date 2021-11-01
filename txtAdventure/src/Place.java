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
    private int counter = 1;
    private MyObject[] placeObjects;
    private Place[] accessiblePlaces = new Place[4];
    private int index = 0;


    //Constructor
    public Place(int maxSpace, String name, String text) {
        this.maxSpace = maxSpace;
        this.name = name;
        count = 0;
        placeObjects = new MyObject[maxSpace];
        this.text = text;
    }

    //Logic for the place and
    public void placeLogic(int index, Adventurer adventurer){
        showPlace();
        setCounter(1);
        int input = showOptions(index, counter);
        selection(index, input, adventurer, counter);
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
        setCounter(c);
        System.out.println("Opiton 9: Inventory");
        int input = inputReader.readInt();
        return input;
    }


    //Method for the selection by the user
    private void selection(int indexx, int input, Adventurer adventurer, int counter){
        if (input >= index + 1){
            objectSelection(input, adventurer, indexx);
        }else if (input > 0){
            accessiblePlaces[input-1].placeLogic(indexx, adventurer);
        }else{
            System.out.println("Invalid");
            placeLogic(indexx, adventurer);
        }
    }

    //Method to avoid redundance
    public void objectSelection(int input, Adventurer adventurer, int indexx){
        if (input > index && input <= counter) {
            adventurer.getBackpack().fillBackpack(placeObjects[input - index - 1]);
            placeObjects = ArrayUtils.remove(placeObjects, input - index - 1);
            count--; //lowers the counter for the array: placeObjects
            adventurer.getBackpack().showInventory();
        }
        else if(input == 9){
            MyObject myObj = adventurer.getBackpack().inventory();
            if (myObj != null) {
                droppItem(myObj);
            }
        }
        else{
            System.out.println("Invalid");
        }
        placeLogic(indexx, adventurer);
    }


    //Show options to do in the place
    public int showOptions(int indexx, int counter){
        for (int i = 0; i < index; i++) {
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

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void addAccessiblePlaces(Place place){
        accessiblePlaces[index] = place;
        index++;
    }
}
