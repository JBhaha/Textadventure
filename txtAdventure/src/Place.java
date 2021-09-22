import java.util.Scanner;

/**
 * Class for the places
 **/

public class Place {
    static Scanner scanner;

    private int maxSpace;
    private int placeSpace;
    private int count;
    private MyObject[] placeObjects;

    public Place(int maxSpace, int placeSpace){
        this.maxSpace = maxSpace;
        this.placeSpace = placeSpace;
        count = 0;
    }

    public void addObjectsToPlace(MyObject theObject){
        placeObjects[count] = theObject;
        count++;
    }

    public int getMaxSpace() {
        return maxSpace;
    }

    public void setMaxSpace(int maxSpace) {
        this.maxSpace = maxSpace;
    }

    public int getPlaceSpace() {
        return placeSpace;
    }

    public void setPlaceSpace(int placeSpace) {
        this.placeSpace = placeSpace;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
