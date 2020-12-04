package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner SCANNER;

    static {
        SCANNER = new Scanner(System.in);
    }

    private InputView() {}

    public static String inputUserName() {
        System.out.println(INPUT_NAME_MESSAGE);
        return SCANNER.next();
    }

    public static int inputHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        return SCANNER.nextInt();
    }
}
