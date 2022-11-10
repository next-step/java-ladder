package ladder;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static String stringInput() {
        return scanner.next();
    }

    public static int integerInput() {
        return scanner.nextInt();
    }
}
