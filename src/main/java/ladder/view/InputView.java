package ladder.view;

import java.util.Scanner;

public final class InputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String MESSAGE_INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_INPUT_LADDER_MAX_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String MESSAGE_INPUT_VALUE_INCORRECT = "입력값이 올바르지 않습니다.";
    private static final String USER_SEPARATOR = ",";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public String[] getInputUserNames() {
        System.out.print(MESSAGE_INPUT_USER_NAMES);
        System.out.print(LINE_SEPARATOR);
        String input = scanner.nextLine();
        emptyCheck(input);
        return input.split(USER_SEPARATOR);
    }

    private static void emptyCheck(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_INPUT_VALUE_INCORRECT);
        }
    }

    public int getInputLadderMaxHeight() {
        System.out.print(LINE_SEPARATOR);
        System.out.print(MESSAGE_INPUT_LADDER_MAX_HEIGHT);
        System.out.print(LINE_SEPARATOR);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MESSAGE_INPUT_VALUE_INCORRECT);
        }
    }
}
