package ladder.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String getStringValue() {
        return scanner.nextLine();
    }

    public static int getIntValue() {
        return scanner.nextInt();
    }
}
