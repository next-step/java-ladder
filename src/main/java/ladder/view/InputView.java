package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);
    private static final String SEPARATE_EXPRESSION = ",";

    private static final String PARTICIPANT_PERSON_COMMENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_GAME_REWARD_COMMENT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_COMMENT = "최대 사다리 높이는 몇 개인가요?";

    private static final String GAME_RESULT_OF_USER_COMMENT = "결과를 보고 싶은 사람은?";
    private static final String GAME_RESULT_COMMENT = "실행결과";

    private InputView() {
    }

    public static List<String> inputParticipantPerson() {
        System.out.println(PARTICIPANT_PERSON_COMMENT);
        String[] inputName = sc.next().split(SEPARATE_EXPRESSION);
        return Arrays.asList(inputName);
    }

    public static List<String> inputLadderGameReward() {
        System.out.println("\n"+LADDER_GAME_REWARD_COMMENT);
        String[] inputReward = sc.next().split(SEPARATE_EXPRESSION);
        return Arrays.asList(inputReward);
    }

    public static int inputLadderHeight() {
        System.out.println();
        System.out.println(LADDER_HEIGHT_COMMENT);
        return sc.nextInt();
    }

    public static String inputGameResultOfUser() {
        System.out.println("\n"+ GAME_RESULT_OF_USER_COMMENT);
        return sc.next();
    }

}
