package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String MESSAGE_INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)\n";
    private static final String MESSAGE_INPUT_MAXIMUM_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?\n";
    private static final String MESSAGE_INPUT_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n";
    private static final String COMMA = ",";
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String[] inputUserNames() {
        System.out.print(MESSAGE_INPUT_USER_NAMES);
        return scanner.nextLine().split(COMMA);
    }

    public Integer inputLadderHeight() {
        System.out.print(MESSAGE_INPUT_MAXIMUM_LADDER_HEIGHT);
        return Integer.valueOf(scanner.nextLine());
    }

    public String[] inputResult() {
        System.out.print(MESSAGE_INPUT_RESULT);
        return scanner.nextLine().split(COMMA);
    }
}
