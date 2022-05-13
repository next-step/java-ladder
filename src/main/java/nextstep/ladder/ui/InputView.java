package nextstep.ladder.ui;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MAX_HEIGHT_MESSAGE = "\r\n최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_USER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    public static String getUserNames() {
        System.out.println(INPUT_USER_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public static String getLadderHeight() {
        System.out.println(INPUT_MAX_HEIGHT_MESSAGE);
        return scanner.nextLine();
    }
}
