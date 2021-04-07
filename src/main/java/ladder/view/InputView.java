package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_INPUT_PARTICIPANT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String MESSAGE_INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputParticipantNames() {
        System.out.println(MESSAGE_INPUT_PARTICIPANT);
        return scanner.nextLine();
    }

    public static int inputMaxLadderHeight() {
        System.out.println(MESSAGE_INPUT_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }
}
