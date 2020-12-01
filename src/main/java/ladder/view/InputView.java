package ladder.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final static String INPUT_USERS_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String INPUT_LADDER_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private InputView() {
    }

    public static String printInputUsersMessage() {
        System.out.println(INPUT_USERS_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String printInputLadderMessage() {
        System.out.println(INPUT_LADDER_MESSAGE);
        return SCANNER.nextLine();
    }
}
