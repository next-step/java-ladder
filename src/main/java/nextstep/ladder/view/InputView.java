package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {
    private static final String PARTICIPANT_NAMES_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String EXECUTION_RESULT_INPUT_MESSAGE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT_OF_LADDER_INPUT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> readParticipantNames() {
        System.out.println(PARTICIPANT_NAMES_INPUT_MESSAGE);
        return participantNames(readString());
    }

    public static String readExecutionResult() {
        System.out.println(EXECUTION_RESULT_INPUT_MESSAGE);
        return readString();
    }

    public static int readHeightOfLadder() {
        System.out.println(HEIGHT_OF_LADDER_INPUT_MESSAGE);
        return Integer.parseInt(readString());
    }

    private static String readString() {
        if (SCANNER.hasNextLine()) {
            return SCANNER.nextLine();
        }
        return new Scanner(System.in).nextLine();
    }

    private static List<String> participantNames(String participantNames) {
        return Arrays.stream(participantNames.split(DELIMITER))
                .collect(Collectors.toList());
    }
}
