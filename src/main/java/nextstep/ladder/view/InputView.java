package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String ASK_PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n";
    private static final String ASK_LADDER_HEIGHT = "최대 사다리 높이는 몇개 인가요?";
    private static final String ENTER_NUMBER = "숫자를 입력 하세요";
    private static final String ASK_FIND_PLAYER = "결과를 보고 싶은 사람은?";

    private InputView() {
    }

    public static String askPlayerssName() {
        System.out.println(ASK_PLAYERS_NAME);
        return SCANNER.nextLine();
    }

    public static int askLadderHeight() {
        System.out.println(ASK_LADDER_HEIGHT);
        String height = SCANNER.nextLine();
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            System.out.println(ENTER_NUMBER);
            return askLadderHeight();
        }
    }

    public static String askResults() {
        System.out.print(ASK_RESULTS);
        return SCANNER.nextLine();
    }

    public static String askResultOfPlayer() {
        System.out.println(ASK_FIND_PLAYER);
        return SCANNER.nextLine();
    }
}
