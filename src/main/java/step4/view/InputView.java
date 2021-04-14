package step4.view;

import java.util.Scanner;

import step4.util.StringSpliter;

public class InputView {
    private static final String MESSAGE_INPUT_PLAYER = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String MESSAGE_INPUT_PRIZE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_INPUT_PRIZE_PLAYER = "결과를 보고 싶은 사람은?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String[] inputPlayerNames() {
        System.out.println(MESSAGE_INPUT_PLAYER);
        return StringSpliter.split(scanner.nextLine());
    }

    public static int inputMaxLadderHeight() {
        System.out.println(MESSAGE_INPUT_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String[] inputResultPrizes() {
        System.out.println(MESSAGE_INPUT_PRIZE);
        return StringSpliter.split(scanner.nextLine());
    }

    public static String inputPrizeOfPlayer() {
        System.out.println(MESSAGE_INPUT_PRIZE_PLAYER);
        return scanner.nextLine();
    }
}
