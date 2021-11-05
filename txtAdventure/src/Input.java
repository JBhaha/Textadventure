import java.util.Scanner;

public class Input {
    static Scanner scanner;

    //Construcor
    public Input() {
        scanner = new Scanner(System.in);
    }

    public static String readString() {
        String text = scanner.nextLine();
        return text;
    }

    public int readInt() {
        System.out.println("Choose option:");
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int input = scanner.nextInt();
        return input;
    }

    public double readDouble() {
        while (!scanner.hasNextDouble()) {
            scanner.next();
        }
        double zahl = scanner.nextDouble();
        return zahl;
    }

    public char readChar() {
        char ch = scanner.next().charAt(0);
        while (!Character.isLetter(ch)) {
            ch = scanner.next().charAt(0);
        }
        return ch;
    }

    public boolean readBoolean() {
        while (!scanner.hasNextBoolean()) {
            scanner.next();
        }
        boolean bool = scanner.nextBoolean();
        return bool;
    }
}
