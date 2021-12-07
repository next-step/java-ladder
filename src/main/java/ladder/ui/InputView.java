package ladder.ui;

import java.util.Scanner;

public class InputView {

    private static final String READ_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    public static String readNames() {
        System.out.println(READ_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public static int readHeight() {
        System.out.println(READ_HEIGHT_MESSAGE);
        return scanner.nextInt();
    }

}
