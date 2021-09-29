import java.util.Scanner;

/**
 * Class for the places
 **/

public class Place {
    static Scanner scanner;
    private String text;
    private String name;
    private int maxSpace;
    private int count;
    private MyObject[] placeObjects;

    public Place(int maxSpace, String name, String text) {
        this.maxSpace = maxSpace;
        this.name = name;
        count = 0;
        placeObjects = new MyObject[maxSpace];
        this.text = text;
    }

    public void addObjectsToPlace(MyObject theObject) {
        placeObjects[count] = theObject;
        count++;
    }

    public void printObjects(){
        if (getCount() >= 0) {
            System.out.println("On the Desk is:");
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
        System.out.println("Please select a number:");
    }

    //show the object which ar in the place
    public int hereIs(int counter){
        for (int i = counter; i < count + counter; i++) {
            System.out.println("Option " + i + ": Take " + placeObjects[i-counter].getName());
        }
        System.out.println("Opiton 9: Inventory");
        int input = scanner.nextInt();

        //TODO: Überprüfung der eingabe

        return input;
    }

    public int getMaxSpace() {
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
}
