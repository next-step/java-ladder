package ladder.view;

import java.util.Scanner;

import static ladder.utils.Constants.*;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String[] inputUserName() {
        System.out.println(MSG_INPUT_USER_NAME);
        return scanner.next().split(SYMBOL_COMMA);
    }

    public static String inputLadderHeight() {
        System.out.println();
        System.out.println(MSG_INPUT_LADDER_HEIGHT);
        return scanner.next();
    }
}
