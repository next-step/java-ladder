package ladderstep4.ladder.ui;

import java.util.Scanner;

public class InputView {

    private static final String READ_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String READ_REWARD_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String READ_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String READ_NAME_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static String readNames() {
        System.out.println(READ_NAMES_MESSAGE);
        return scanner.nextLine();
    }

    public static String readPrizes() {
        enter();
        System.out.println(READ_REWARD_MESSAGE);
        return scanner.nextLine();
    }

    public static int readHeight() {
        enter();
        System.out.println(READ_HEIGHT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String readName() {
        enter();
        System.out.println(READ_NAME_MESSAGE);
        return scanner.nextLine();
    }

    private static void enter() {
        System.out.println();
    }

}
