package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    private final static String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String INPUT_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private final static String USER_NAME_DELIMITER = ",";

    public static String[] inputUserNames() {
        System.out.println(INPUT_NAME_MESSAGE);
        return splitNames(scanner.nextLine());
    }

    private static String[] splitNames(String input) {
        return input.split(USER_NAME_DELIMITER);
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_HEIGHT_MESSAGE);
        return toInt(scanner.nextLine());
    }

    private static int toInt(String number) {
        return Integer.parseInt(number.trim());
    }
}
