package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String ASK_USER_NAMES_MENT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String ASK_HEIGHT_MENT = "최대 사다리 높이는 몇 개인가요?";
    private static final String ASK_RESULTS_MENT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String ASK_RESULTS_USER_MENT = "결과를 보고 싶은 사람은?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String askUserNames() {
        System.out.println(ASK_USER_NAMES_MENT);
        return SCANNER.nextLine();
    }

    public static String askResults() {
        System.out.println(ASK_RESULTS_MENT);
        return SCANNER.nextLine();
    }

    public static Integer askHeight() {
        System.out.println(ASK_HEIGHT_MENT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String askResultUserName() {
        System.out.println(ASK_RESULTS_USER_MENT);
        return SCANNER.nextLine();
    }

}
