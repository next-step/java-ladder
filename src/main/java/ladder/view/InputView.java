package ladder.view;

import java.util.Scanner;

public class InputView {

    public static final String NEWLINE = System.lineSeparator();
    public static final String PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String LADDER_HEIGHT = NEWLINE + "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String playerNames() {
        System.out.println(PLAYER_NAMES);
        return scanner.nextLine();
    }

    public static int ladderHeight() {
        System.out.println(LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }
}
