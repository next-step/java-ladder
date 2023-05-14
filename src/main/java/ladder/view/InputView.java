package ladder.view;

import java.util.Scanner;

public class InputView {
    public static final String LINE_SEPARATOR = System.lineSeparator();

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine();
    }

    public static int inputMaximumHeightOfLadder() {
        System.out.printf("%s최대 사다리 높이는 몇 개인가요?%n", LINE_SEPARATOR);
        return SCANNER.nextInt();
    }
}
