package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAXIMUM_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private String inputStringValue() {
        return scanner.nextLine();
    }

    private int inputIntValue() {
        int intValue = scanner.nextInt();
        scanner.nextLine();
        return intValue;
    }

    public String inputParticipantsName() {
        System.out.println(INPUT_PARTICIPANTS_NAME);
        return inputStringValue();
    }

    public int inputMaximumHeight() {
        System.out.println("\n" + INPUT_MAXIMUM_HEIGHT);
        return inputIntValue();
    }

    public void scannerClose() {
        scanner.close();
    }
}
