package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String LOTTO_NUMBER_SEPARATOR = ", ";

    private static final String ASK_USER_NAMES_MENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_HEIGHT_MENT = "최대 사다리 높이는 몇 개인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String askUserNames() {
        System.out.println(ASK_USER_NAMES_MENT);
        return SCANNER.nextLine();
    }

    public static Integer askHeight() {
        System.out.println(ASK_HEIGHT_MENT);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
