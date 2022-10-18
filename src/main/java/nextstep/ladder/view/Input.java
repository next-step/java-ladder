package nextstep.ladder.view;

import java.util.Scanner;

public class Input {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String ENTER_NAME_OF_PERSON = "참여할 사람 이름을 입력하세요. (이름은 쉼표로 구분해야 하며, 최대 다섯 자를 넘을 수 없습니다.)";
    private final static String ENTER_HEIGHT_OF_LADDER = "사다리의 최대 높이는 몇인가요?";
    private final static String INVALID_NAME_FORMAT = "입력된 사람의 이름 포맷이 올바르지 않습니다.";
    private final static String NOT_ENTERED_VALUE = "값이 입력되지 않았습니다.";
    private final static String SEPARATOR_COMMA = ",";

    private Input() {
        throw new AssertionError();
    }

    public static String[] inputPerson() {
        System.out.println(ENTER_NAME_OF_PERSON);
        String input = SCANNER.nextLine();
        if (containsSeparator(input)) {
            return input.split(SEPARATOR_COMMA);
        }
        throw new IllegalArgumentException(INVALID_NAME_FORMAT);
    }

    public static int inputHeightOfLadder() {
        System.out.println(ENTER_HEIGHT_OF_LADDER);
        return SCANNER.nextInt();
    }

    private static boolean containsSeparator(String input) {
        if (isNullOrSpace(input)) {
            throw new IllegalArgumentException(NOT_ENTERED_VALUE);
        }
        return input.contains(SEPARATOR_COMMA);
    }

    private static boolean isNullOrSpace(String text) {
        return text == null || text.equals("");
    }
}
