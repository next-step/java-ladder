package ladder.view;

import java.util.Scanner;

public class InputView {
    public static String promptThenString(String message) {
        System.out.println(message);
        return getScanner().nextLine();
    }

    public static int promptThenInt(String message) {
        System.out.println(message);
        return getScanner().nextInt();
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
