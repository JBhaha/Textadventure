import java.util.Scanner;
public class Logic {

    static Scanner scanner;

    private String prompt;
    private int userChoices;

    // Method to get console input from user
    public int readInt(){
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter a number");
            }
        }while(input < 1 || input > userChoices);
            return input;

    }

    // Method to clear console

    public void clearConsole(){
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // Method to stop game until user enters anything
    public void pressToContinue(){
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

}
