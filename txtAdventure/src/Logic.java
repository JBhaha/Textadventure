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

    // Method to enter a decision
    public void enter(){
        int input = 0;
        int inputnum = 3;



        System.out.println("please select a number: ");
        System.out.println("Option 1: ");
        System.out.println("Option 2: ");
        System.out.println("Option 3: ");
        input = scanner.nextInt();
        if (input == 1) {
            System.out.println("do option 1");
        }else if (input == 2){
            System.out.println("do option 2");
        }
        else if (input == 3){
            System.out.println("do option 3");
        }



    }

    // Method for help
    public void help(){



    }

}
