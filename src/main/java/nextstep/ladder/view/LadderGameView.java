package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;

public class LadderGameView {

    private static final String USER_NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";

    public static List<String> inputPlayers() {
        System.out.println(USER_NAME_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String userNameInput = scanner.nextLine();
        return LadderGameViewHelper.parseUserNameInput(userNameInput);
    }

    public static Integer inputLadderHeight() {
        System.out.println(LADDER_HEIGHT_INPUT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
