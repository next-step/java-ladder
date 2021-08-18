package ladder.view;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_PLAYER_NAMES_DELIMITER = ",";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream printStream = System.out;

    public static void printPlayerNameInputMessage() {
        printStream.println(PLAYER_NAME_INPUT_MESSAGE);
    }

    public static List<String> inputPlayerNames() {
        return Arrays.asList(scanner.nextLine().split(INPUT_PLAYER_NAMES_DELIMITER));
    }

    public static void printLadderHeightInputMessage() {
        printStream.println(LADDER_HEIGHT_INPUT_MESSAGE);
    }

    public static int inputLadderHeight() {
        return scanner.nextInt();
    }

    public static void printNewLine() {
        printStream.println();
    }
}
