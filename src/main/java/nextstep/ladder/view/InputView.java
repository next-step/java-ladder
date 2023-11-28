package nextstep.ladder.view;

import nextstep.ladder.domain.util.InputParser;

import java.util.Scanner;

public class InputView {
    public static final String LADDER_HEIGHT_INPUT_MSG = "최대 사다리 높이는 몇 개인가요?";
    private final static Scanner SCANNER = new Scanner(System.in);
    public static final String PARTICIPANTS_INPUT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String RESULT_INPUT_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String PARTICIPANT_LADDER_RESULT_INPUT_MSG = "결과를 보고 싶은 사람은?";
    public static final String INVALID_RESULT_COUNT_MSG = "참가자의 수와 결과의 수는 다를 수 없습니다.";


    private InputView() {
    }

    public static String[] inputParticipants() {
        System.out.println(PARTICIPANTS_INPUT_MSG);
        final String participantTexts = SCANNER.next();

        return InputParser.parse(participantTexts);
    }

    public static int inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_MSG);
        return SCANNER.nextInt();
    }

    public static String[] inputResult(final int countOfPerson) {
        System.out.println(RESULT_INPUT_MSG);
        final String resultText = SCANNER.next();
        final String[] results = InputParser.parse(resultText);

        resultNumberCheck(countOfPerson, results);

        return results;
    }

    private static void resultNumberCheck(final int countOfPerson, final String[] results) {
        if (results.length != countOfPerson) {
            throw new IllegalArgumentException(INVALID_RESULT_COUNT_MSG);
        }
    }
    public static String inputParticipantLadderResult() {
        System.out.println(PARTICIPANT_LADDER_RESULT_INPUT_MSG);
        return SCANNER.next();
    }
}
