package step4.view;

import step4.utils.IntegerUtil;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PARTICIPANTS_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n";
    private static final String INPUT_REWARDS_NAME_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?\n";
    private static final String INPUT_PARTICIPANT_RESULT_MESSAGE = "결과를 보고 싶은 사람은?\n";
    private static final Scanner sc = new Scanner(System.in);

    public static String inputParticipantsName() {
        System.out.print(INPUT_PARTICIPANTS_NAME_MESSAGE);
        return sc.nextLine();
    }

    public static String inputRewardsName() {
        System.out.print(INPUT_REWARDS_NAME_MESSAGE);
        return sc.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.print(INPUT_LADDER_HEIGHT_MESSAGE);
        return parseInt(sc.nextLine());
    }

    public static String inputParticipantResult() {
        System.out.print(INPUT_PARTICIPANT_RESULT_MESSAGE);
        String input = sc.nextLine();
        return input;
    }

    private static int parseInt(String input) {
        return IntegerUtil.parseInt(input);
    }
}
