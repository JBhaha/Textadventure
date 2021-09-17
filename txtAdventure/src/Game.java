import java.util.Scanner;
/**
 * Class for places
 **/
public class Game {
    static Scanner scanner;
    static int houseSpace = 3;
    static int space = 5;
    static Object[] houseObjects = new Object[space];
    Adventurer alex = new Adventurer("Alex", 40, 50, 1);
    static Backpack defaultBackpack = new Backpack(20);
    //Constructor
    public Game(){
        scanner = new Scanner(System.in);
        alex.setBackpack(defaultBackpack);
        houseObjects[0] = new Object("rope");
        houseObjects[1] = new Object("sword");
        houseObjects[2] =  new Object("apple");
    }

    //Start method of the Textadventure!
    public void start(){
        System.out.println("Welcome to the Textadventure!\nWe hope you enjoy it. Let's get started!");
        house();
    }

    //Starting House
    public void house() {
        System.out.println("You're standing in a dark room. You can't remember how you got here.\n" +
                "You stand up. There's a door at the end of the room.");
        if (houseSpace >= 0) {
            System.out.println("On the Desk is:");
            for (int i = 0; i < houseSpace; i++) {
                System.out.println("- " + houseObjects[i].getName());
            }
        }
        String next = whatDoYouDo();

        //check if user wants to take something
        boolean take = false;
        for (int i = 0; i < houseSpace; i++) {
            if (next.equals("take " + houseObjects[i].getName())) {
                alex.getBackpack().fillBackpack(houseObjects[i]);
                emptyRoom(houseObjects[i]);
                house();
                take = true;
            }
        }
        if (!take && next.equals("use door")) {
            garden();
        } else if (!take){
            error();
            house();
        }
    }

    //outside starting house
    public void garden(){
        System.out.println("You're standing in the garden in front of the house where you woke up.\n" +
                "Theres a door into the house and a small path into the forest.");
        String next = whatDoYouDo();
        if (next.equals("use door")){
            house();
        }else if (next.equals("use path")){
            path();
        }else{
            error();
        }
    }

    //path in front of the garden
    public void path(){
        System.out.println("You're walking on the path. Suddently the path has a dead end.\n" +
                "Behind you, there's the path back to the garden.");
        String next = whatDoYouDo();
        if (next.equals("use path")){
            garden();
        }else{
            error();
            path();
        }
    }


    //Method for WHAT DO YOU DO?????
    public String whatDoYouDo(){
        System.out.println("What do you do?");
        String answer = scanner.nextLine();
        return answer;
    }

    //Method for errors because of the user
    public void error(){
        System.out.println("Sorry! You're input was invalid. Please check your Input! Write the keyword use + " +
                "the Object you want to use!!");
    }


    //Method for taking something from the place
    public void emptyRoom(Object object){
        Object[] help = new Object[houseSpace];
        String name = object.getName();
        int i = 0;
        while (!houseObjects[i].getName().equals(name)){
            help[i] = houseObjects[i];
            houseObjects[i] = null;
            i++;
        }
        houseObjects[i] = null;
        for (int j = i + 1; j < houseSpace; j++) {
            help[j - 1] = houseObjects[j];
            houseObjects[j] = null;
        }
        houseSpace--;
        for (int j = 0; j < houseSpace; j++) {
            houseObjects[j] = help[j];
        }
    }

}
