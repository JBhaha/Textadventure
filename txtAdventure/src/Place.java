import java.util.Scanner;

/**
 * Class for the places
 **/

public class Place {
    static Scanner scanner;
    private String name;
    private int maxSpace;
    private int count;
    private MyObject[] placeObjects;

    public Place(int maxSpace, String name) {
        this.maxSpace = maxSpace;
        this.name = name;
        count = 0;
        placeObjects = new MyObject[maxSpace];
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
