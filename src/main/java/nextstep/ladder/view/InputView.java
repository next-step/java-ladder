package nextstep.ladder.view;

import nextstep.ladder.domain.player.Players;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_PARTICIPANTS_STATEMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_STATEMENT = "최대 사다리 높이는 몇 개인가요?";
    private static final String NAMES_DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static Players inputParticipants() {
        printStatement(INPUT_PARTICIPANTS_STATEMENT);

        return Arrays.stream(readNames())
                .map(String::trim)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Players::init));
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

    private static String[] readNames() {
        return SCANNER.nextLine()
                .split(NAMES_DELIMITER);
    }
}
