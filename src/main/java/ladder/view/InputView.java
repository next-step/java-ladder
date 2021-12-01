package ladder.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);
    private InputView() {}

    public static String getStringValue(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
