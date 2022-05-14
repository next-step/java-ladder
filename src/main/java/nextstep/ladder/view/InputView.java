package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String PARTICIPANT_NAMES_PROMPT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_PROMPT = "최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_HEIGHT_LESS_THAN_STANDARD_ERROR_MESSAGE = "사다리의 높이는 0보다 커야합니다. (입력된 사다리의 높이: %d)";
    private static final String SPLIT_BASIC_REGEX = ",";

    private static final int LADDER_HEIGHT_MINIMUM_BOUNDARY = 0;

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static String[] inputParticipantNames() {
        System.out.println(PARTICIPANT_NAMES_PROMPT);

        String names = SCANNER.nextLine();

        return splitParticipantNames(names);
    }

    private static String[] splitParticipantNames(String names) {
        return names.split(SPLIT_BASIC_REGEX);
    }

    public static int inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_PROMPT);

        int height = SCANNER.nextInt();
        validateHeight(height);

        return height;
    }

    private static void validateHeight(int height) {
        if(height > LADDER_HEIGHT_MINIMUM_BOUNDARY) {
            throw new IllegalArgumentException(String.format(LADDER_HEIGHT_LESS_THAN_STANDARD_ERROR_MESSAGE, height));
        }
    }
}
