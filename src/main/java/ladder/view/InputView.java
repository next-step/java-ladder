package ladder.view;

import java.util.Scanner;

public class InputView {

    private static String inputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String showMessage(String message) {
        System.out.println(message);
        return inputValue();
    }
}
