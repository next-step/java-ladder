package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputNames(Runnable messagePrinter) {
        messagePrinter.run();
        return scanner.nextLine();
    }

    public static int inputLadderHeight(Runnable messagePrinter) {
        messagePrinter.run();
        return scanner.nextInt();
    }
}
