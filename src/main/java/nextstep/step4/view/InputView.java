package nextstep.step4.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private static final String INPUT_USER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    public static final String INPUT_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    public static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public String getUsers() {
        System.out.println(INPUT_USER);
        return scanner.nextLine();
    }

    public String getResults() {
        System.out.println(INPUT_RESULT);
        return scanner.nextLine();
    }

    public String getHeight() {
        System.out.println(INPUT_HEIGHT);
        return scanner.nextLine();
    }
}
