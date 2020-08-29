package ladder.view;

import java.util.Scanner;

public final class InputView {
    private static final String PARTICIPANTS_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String LADDER_REWARD_MESSAGE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String WISH_PARTICIPANT_RESULT_MESSAGE = "\n결과를 보고 싶은 사람은?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String scanParticipantNames() {
        System.out.println(PARTICIPANTS_NAME_MESSAGE);

        return scanner.nextLine();
    }

    public static int scanLadderHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);

        return Integer.parseInt(scanner.nextLine());
    }

    public static String scanLadderReward() {
        System.out.println(LADDER_REWARD_MESSAGE);

        return scanner.nextLine();
    }

    public static String scanWishParticipantName() {
        System.out.println(WISH_PARTICIPANT_RESULT_MESSAGE);

        return scanner.nextLine();
    }
}
