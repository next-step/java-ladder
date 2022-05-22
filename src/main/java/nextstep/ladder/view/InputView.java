package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String EXECUTION_RESULT_PROMPT = "실행 결과를 입력하세요. (결과를 쉼표(,)로 구분하세요)";
    private static final String PARTICIPANT_RESULT_PROMPT = "결과를 보고 싶은 사람은?";
    private static final String PARTICIPANT_NAMES_PROMPT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_PROMPT = "최대 사다리 높이는 몇 개인가요?";
    private static final String SPLIT_BASIC_REGEX = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String[] inputParticipantNames() {
        System.out.println(PARTICIPANT_NAMES_PROMPT);

        String names = SCANNER.nextLine();

        return splitInputValues(names);
    }

    public static String[] inputExecutionResults() {
        System.out.println(EXECUTION_RESULT_PROMPT);
        String executionResults = SCANNER.nextLine();
        return splitInputValues(executionResults);
    }

    private static String[] splitInputValues(String values) {
        return values.split(SPLIT_BASIC_REGEX);
    }

    public static int inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_PROMPT);
        String height = SCANNER.nextLine();

        return convertToInt(height);
    }

    private static int convertToInt(String height) {
        return Integer.parseInt(height);
    }

    public static String inputParticipantResult() {
        System.out.println(PARTICIPANT_RESULT_PROMPT);
        return SCANNER.nextLine();
    }
}
