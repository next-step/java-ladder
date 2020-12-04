package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_WHEN_ASK_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_WHEN_ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String askNames() {
        System.out.println(MESSAGE_WHEN_ASK_USER_NAMES);
        return scanner.nextLine();
    }

    public static int askLadderHeight() {
        System.out.println(MESSAGE_WHEN_ASK_LADDER_HEIGHT);
        return scanner.nextInt();
    }
}
