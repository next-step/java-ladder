package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String INSERT_PLAYERS = "\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MAX_LADDER_HEIGHT = "\n최대 사다리 높이는 몇 개인가요?";

    public static String questionPlayers() {
        System.out.println(INSERT_PLAYERS);
        return getInputValue();
    }

    public static String questionHeight() {
        System.out.println(MAX_LADDER_HEIGHT);
        return getInputValue();
    }

    private static String getInputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
