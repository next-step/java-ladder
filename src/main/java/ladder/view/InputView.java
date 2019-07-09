package ladder.view;

import java.util.List;
import java.util.Scanner;

import ladder.util.StringSplitter;

public final class InputView {
    private static final String MESSAGE_FOR_PARTICIPANTS_INPUT = "참여할 사람 이름을 입력하세요. (이름은 \"%s\"로 구분하세요)";
    private static final String MESSAGE_FOR_LADDER_HEIGHT_INPUT = "최대 사다리 높이는 몇 인가요?";
    private static final String MESSAGE_FOR_REWARD_INPUT = "실행 결과를 입력하세요. (결과는 \"%s\"로 구분하세요)";
    public static final String MESSAGE_FOR_RESULT_CHOICE = "결과를 보고 싶은 사람은?";

    public static List<String> inputParticipants() {
        return getSeparatedValues(MESSAGE_FOR_PARTICIPANTS_INPUT);
    }

    public static List<String> inputRewards() {
        return getSeparatedValues(MESSAGE_FOR_REWARD_INPUT);
    }

    public static int inputLadderHeight() {
        System.out.println(MESSAGE_FOR_LADDER_HEIGHT_INPUT);

        final Scanner scanner = new Scanner(System.in);
        final int input = scanner.nextInt();

        scanner.nextLine();
        System.out.println();

        return input;
    }

    public static String inputChoiceResult() {
        System.out.println(MESSAGE_FOR_RESULT_CHOICE);

        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        System.out.println();
        return input;
    }

    private InputView() {}

    private static List<String> getSeparatedValues(String message) {
        System.out.println(String.format(message, StringSplitter.SEPARATOR));

        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        System.out.println();
        return StringSplitter.split(input);
    }
}
