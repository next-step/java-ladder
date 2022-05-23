package ladder.view;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);
    public static String scan(String payload) {
        System.out.println(payload);
        return scanner.nextLine();
    }
}
