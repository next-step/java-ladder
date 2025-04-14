package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_USER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_PLAY_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputUserName() {
        System.out.println(INPUT_USER_NAME);
        return scanner.nextLine();
    }

    public int inputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputPlayResult() {
        System.out.println(INPUT_PLAY_RESULT);
        return scanner.nextLine();
    }
}
