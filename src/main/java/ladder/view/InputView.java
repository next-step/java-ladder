package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class InputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String SEPARATOR = ",";
    private static final String INPUT_USER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULT_VALUES_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_MAX_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULT_VALUE_TARGET_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String INPUT_VALUE_INCORRECT_MESSAGE = "입력값이 올바르지 않습니다.";

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getInputUserNames() {
        System.out.print(INPUT_USER_NAMES_MESSAGE);
        return getInputValuesToSeparate();
    }

    public List<String> getInputResultValues() {
        System.out.print(LINE_SEPARATOR + INPUT_RESULT_VALUES_MESSAGE);
        return getInputValuesToSeparate();
    }

    private List<String> getInputValuesToSeparate() {
        System.out.print(LINE_SEPARATOR);
        String input = scanner.nextLine();
        emptyCheck(input);
        return Arrays.asList(input.split(SEPARATOR));
    }

    private static void emptyCheck(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INPUT_VALUE_INCORRECT_MESSAGE);
        }
    }

    public int getInputLadderMaxHeight() {
        System.out.print(LINE_SEPARATOR + INPUT_LADDER_MAX_HEIGHT_MESSAGE + LINE_SEPARATOR);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALUE_INCORRECT_MESSAGE);
        }
    }

    public String getInputResultValueTarget() {
        System.out.print(LINE_SEPARATOR + LINE_SEPARATOR + INPUT_RESULT_VALUE_TARGET_MESSAGE + LINE_SEPARATOR);
        return scanner.nextLine();
    }
}