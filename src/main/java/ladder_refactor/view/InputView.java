package ladder_refactor.view;

import java.util.Scanner;

public class InputView {

    private static final String INSERT_PLAYERS = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INSERT_RESULT = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String FIND_PLAYER_RESULT = "\n결과를 보고 싶은 사람은?";

    public static String questionPlayers() {
        System.out.println(INSERT_PLAYERS);
        return getInputValue();
    }

    public static String questionAnswers() {
        System.out.println(INSERT_RESULT);
        return getInputValue();
    }

    public static String questionHeight() {
        System.out.println(MAX_LADDER_HEIGHT);
        return getInputValue();
    }

    public static String questionFindResult() {
        System.out.println(FIND_PLAYER_RESULT);
        return getInputValue();
    }

    private static String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
