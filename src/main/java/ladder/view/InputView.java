package ladder.view;

import java.util.Scanner;

import static ladder.utils.StringUtils.split;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String ASK_USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String NO_NUMBER_INPUT = "숫자를 입력해야 합니다.";

    public static String[] askUserName() {
        System.out.println(ASK_USER_NAME);
        return split(SCANNER.nextLine());
    }

    public static int askLadderHeight() {
        System.out.println(ASK_LADDER_HEIGHT);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (RuntimeException e) {
            System.out.println(NO_NUMBER_INPUT);
            return askLadderHeight();
        }
    }
}
