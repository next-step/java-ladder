package step2.view;

import java.util.Scanner;

import static step2.validator.InputValidator.validateParseInt;

public class InputView {
    private static final String INPUT_PARTICIPANT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_LADDER_REWARD_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    private static final Scanner scanner = new Scanner(System.in);

    public static String inputParticipantName() {
        System.out.println(INPUT_PARTICIPANT_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        String input = scanner.nextLine();
        validateParseInt(input);
        return Integer.parseInt(input);
    }

    public static String inputLadderReward() {
        System.out.println(INPUT_LADDER_REWARD_MESSAGE);
        return scanner.nextLine();
    }
}
