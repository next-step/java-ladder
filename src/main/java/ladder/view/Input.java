package ladder.view;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);
    public static int scanNumber() {
        System.out.println("Put max height of ladders");
        return scanner.nextInt();
    }

    public static String scanName() {
        System.out.println("Put player names separated by ','.");
        return scanner.nextLine();
    }
}
