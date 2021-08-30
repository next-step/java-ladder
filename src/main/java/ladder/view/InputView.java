package ladder.view;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PLAYER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_STRING_DELIMITER = ",";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String PLAYER_NAME_FOR_LADDER_RESULT_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String NEW_LINE = "\n";

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintStream printStream = System.out;

    public static List<String> inputPlayerNames() {
        printStream.println(PLAYER_NAME_INPUT_MESSAGE);
        return Arrays.asList(scanner.nextLine().split(INPUT_STRING_DELIMITER));
    }

    public static int inputLadderHeight() {
        printStream.println(NEW_LINE + LADDER_HEIGHT_INPUT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> inputLadderResults() {
        printStream.println(NEW_LINE + LADDER_RESULT_INPUT_MESSAGE);
        return Arrays.asList(scanner.nextLine().split(INPUT_STRING_DELIMITER));
    }

    public static String inputPlayerNameForLadderResult() {
        printStream.println(NEW_LINE + PLAYER_NAME_FOR_LADDER_RESULT_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
