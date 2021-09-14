package step4.view;

import java.util.Scanner;

public class InputView {
    private static final String USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String RESULT_NAME = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner SC = new Scanner(System.in);

    public static String requireUserName() {
        System.out.println(USER_NAME);
        return SC.nextLine();
    }

    public static String requireResultNames() {
        System.out.println(RESULT_NAME);
        return SC.nextLine();
    }

    public static Integer requireHeight() {
        System.out.println(HEIGHT);
        return Integer.parseInt(SC.nextLine());
    }
}
