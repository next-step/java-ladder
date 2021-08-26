package ladder.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PARTICIPANTS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_EXECUTION_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_MAXIMUM_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_WANTED_RESULT_OF_NAME = "결과를 보고 싶은 사람은?";


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

    public String inputExecutionResult() {
        System.out.print(System.lineSeparator());
        System.out.println(INPUT_EXECUTION_RESULT);
        return inputStringValue();
    }

    public int inputMaximumHeight() {
        System.out.print(System.lineSeparator());
        System.out.println(INPUT_MAXIMUM_HEIGHT);
        return inputIntValue();
    }

    public String inputWantedResultOfName() {
        System.out.print(System.lineSeparator());
        System.out.println(INPUT_WANTED_RESULT_OF_NAME);
        return inputStringValue();
    }

    public void scannerClose() {
        scanner.close();
    }
}
