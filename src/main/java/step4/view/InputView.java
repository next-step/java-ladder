package step4.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_USERNAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_POINT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_USERNAME = "결과를 보고 싶은 사람은?";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputUsernames() {
        System.out.println(INPUT_USERNAME_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputResultPoint() {
        System.out.println(INPUT_RESULT_POINT);
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputResultUsername() {
        System.out.println(INPUT_RESULT_USERNAME);
        return scanner.nextLine();
    }

}
