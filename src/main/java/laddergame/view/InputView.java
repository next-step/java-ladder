package laddergame.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String enterPlayerNames() {
        return scanner.nextLine();
    }
}
