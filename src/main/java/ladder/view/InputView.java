package ladder.view;

import ladder.util.StringUtil;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String PLAYER_NAMES_DELIMITER = ",";
    private static final String MAX_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputPlayers() {
        String names = inputString(PLAYER_NAMES_MESSAGE);

        return StringUtil.splitValues(names, PLAYER_NAMES_DELIMITER);
    }

    public static int inputHeight() {
        return inputInt(MAX_LADDER_HEIGHT_MESSAGE);
    }

    private static String inputString(final String message) {
        System.out.println();
        System.out.println(message);

        return SCANNER.nextLine();
    }

    private static int inputInt(final String message) {
        System.out.println(message);

        return Integer.parseInt(SCANNER.nextLine());
    }
}
