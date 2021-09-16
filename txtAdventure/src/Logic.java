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

}
