package ladder.view;

import java.util.List;
import java.util.Scanner;

import ladder.util.NamesSplitter;

public final class InputView {
    public static final String MESSAGE_FOR_PARTICIPANTS_INPUT = "참여할 사람 이름을 입력하세요. (이름은 \"%s\"로 구분하세요)";
    private static final String MESSAGE_FOR_LADDER_HEIGHT_INPUT = "최대 사다리 높이는 몇 인가요?";

    public static List<String> inputParticipants() {
        System.out.println(String.format(MESSAGE_FOR_PARTICIPANTS_INPUT, NamesSplitter.SEPARATOR));

        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        System.out.println();
        return NamesSplitter.split(input);
    }

    public static int inputLadderHeight() {
        System.out.println(MESSAGE_FOR_LADDER_HEIGHT_INPUT);

        final Scanner scanner = new Scanner(System.in);
        final int input = scanner.nextInt();

        scanner.nextLine();
        System.out.println();

        return input;
    }

    private InputView() {}
}
