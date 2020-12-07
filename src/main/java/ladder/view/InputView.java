package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String USER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표로(,) 구분하세요)";
    private static final String REWARDS_MESSAGE = "실행 결과를 입력하세요. (각 결과를 쉼표로(,) 구분하세요)";
    private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_MESSAGE = "결과를 보고 싶은 사람은?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String askNames() {
        System.out.println(USER_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public static String askRewards() {
        System.out.println(REWARDS_MESSAGE);
        return scanner.nextLine();
    }

    public static int askLadderHeight() {
        System.out.println(LADDER_HEIGHT_MESSAGE);
        return scanner.nextInt();
    }

    public static String askResult() {
        System.out.println(RESULT_MESSAGE);
        return scanner.next();
    }
}
