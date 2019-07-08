package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_FOR_INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_FOR_MAXIMUM_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String MESSAGE_FOR_PRIZES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_FOR_WANTED_RESULT = "결과를 보고 싶은 사람은?";

    private static Scanner scanner = new Scanner(System.in);

    public static String askPlayers() {
        System.out.println(MESSAGE_FOR_INPUT_PLAYER_NAMES);
        return scanner.nextLine();
    }

    public static String askPrizes() {
        printEmptyLine();
        System.out.println(MESSAGE_FOR_PRIZES);
        return scanner.nextLine();
    }

    public static int askHeight() {
        printEmptyLine();
        System.out.println(MESSAGE_FOR_MAXIMUM_LADDER_HEIGHT);
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public static String askWhichResultWant() {
        printEmptyLine();
        System.out.println(MESSAGE_FOR_WANTED_RESULT);
        return scanner.nextLine();
    }

    static void printEmptyLine() {
        System.out.println();
    }
}
