package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputTryLine(String message) {
        System.out.println(message);
        return scanner.next();
    }

    public static int inputTryNo(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }
}
