package ladder.view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);
    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";

    private InputView() {
    }

    public static String inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        validateParticipants(input);

        return input;
    }

    private static void validateParticipants(final String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int input = scanner.nextInt();
        validateLadderHeight(input);

        return input;
    }

    private static void validateLadderHeight(final int input) {
        if (input == 0) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }
}
