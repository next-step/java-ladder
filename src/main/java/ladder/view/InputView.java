package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String WHEN_ASK_USER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

    private static final Scanner scanner = new Scanner(System.in);

    public static String askNames() {
        System.out.println(WHEN_ASK_USER_NAMES_MESSAGE);
        return scanner.nextLine();
    }
}
