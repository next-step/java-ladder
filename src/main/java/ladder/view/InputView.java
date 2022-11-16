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
        return scanner.nextLine();
    }

    public static String inputPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int input = scanner.nextInt();
        scanner.nextLine();

        return input;
    }

    public static String inputParticipant() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String input = scanner.nextLine();
        validateStringValue(input);

        return input;
    }

    private static void validateStringValue(final String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }
}
