package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PARTICIPANTS_STATEMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_GIFTS_STATEMENT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_STATEMENT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_PLAYER_TO_SEE_STATEMENT = "결과를 보고 싶은 사람은? (종료하려면 exit 를 입력하세요)";
    private static final String NAMES_DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static List<String> inputParticipantsNames() {
        printStatement(INPUT_PARTICIPANTS_STATEMENT);

        return readLineAndCollectToList();
    }

    public static List<String> inputGifts() {
        printStatement(INPUT_GIFTS_STATEMENT);

        return readLineAndCollectToList();
    }

    private static List<String> readLineAndCollectToList() {
        return Arrays.stream(readLineAndSplit())
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int inputLadderHeight() {
        printStatement(INPUT_LADDER_HEIGHT_STATEMENT);

        return getInt();
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static int getInt() {
        return Integer.parseInt(
                SCANNER.nextLine()
                        .trim()
        );
    }

    private static String[] readLineAndSplit() {
        return SCANNER.nextLine()
                .split(NAMES_DELIMITER);
    }

    public static String inputPlayerToSee() {
        printStatement(INPUT_PLAYER_TO_SEE_STATEMENT);

        return SCANNER.nextLine()
                .trim();
    }
}
