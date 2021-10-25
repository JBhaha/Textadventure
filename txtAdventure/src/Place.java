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
    //private int index = 0;

    //Constructor
    public Place(int maxSpace, String name, String text) {
        this.maxSpace = maxSpace;
        this.name = name;
        count = 0;
        placeObjects = new MyObject[maxSpace];
        this.text = text;
    }

    //Logic for the place and
    public void placeLogic(Place[] places, int index, Adventurer adventurer){
        showPlace();
        setCounter(1);
        int input = showOptions(index, counter, places);
        selection(index, input, places, adventurer, counter);
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

    //show the text for the place
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
    private void selection(int index, int input, Place[] places, Adventurer adventurer, int counter){
        if (index != 0){
            if (index < 3) {
                if (input == 1) {
                    index--;

                }
                else if (input == 2) {
                    index++;

                }
                else{
                    objectSelection(input, 3, adventurer, counter);
                }
            }
            else{
                if (input == 1){
                    index--;
                }else{
                    objectSelection(input, 3, adventurer, counter);
                }
            }
        }
        else{
            if (input == 1){
                index++;
            }else{
                objectSelection(input, 2, adventurer, counter);
            }
        }
        places[index].placeLogic(places, index, adventurer);
    }

    //Method to avoid redundance
    public void objectSelection(int input, int num, Adventurer adventurer, int counter){
        if (input < counter) {
            for (int i = num; i < count + num; i++) {
                if (input == i) {
                    adventurer.getBackpack().fillBackpack(placeObjects[input - num]);
                    placeObjects = ArrayUtils.remove(placeObjects, input - num);
                    count--;
                    adventurer.getBackpack().showInventory();
                }
            }
        }
        else if (input == 9){
            MyObject myObj = adventurer.getBackpack().inventory();
            if (myObj != null) {
                droppItem(myObj);
            }
        }
        else{
            error();
        }
    }


    //Show options to do in the place
    public int showOptions(int index, int counter, Place[] places){
        System.out.println("Please select a number:");
        if (index != 0){
            if (index < 3){
                System.out.println("Option " + counter + ": " + places[index-1].getName());
                counter++;
                System.out.println("Option " + counter + ": " + places[index+1].getName());
                counter++;
                int input = hereIs(counter);
                return input;
            }else{
                System.out.println("Option " + counter + ": " + places[index-1].getName());
                counter++;
                int input = hereIs(counter);
                return input;
            }
        }else{
            System.out.println("Option " + counter + ": " + places[index+1].getName());
            counter++;
            int input = hereIs(counter);
            return input;
        }
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

}
