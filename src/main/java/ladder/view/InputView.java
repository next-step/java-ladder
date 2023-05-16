package ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static List<String> inputUserNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = SCANNER.nextLine();
        return split(names);
    }

    public static List<String> inputRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String rewards = SCANNER.nextLine();
        return split(rewards);
    }

    private static List<String> split(String names) {
        return List.of(names.split(DELIMITER));
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputNumber();
    }

    public static String inputUserName() {
        return SCANNER.nextLine();
    }

    private static int inputNumber() {
        int input = SCANNER.nextInt();
        SCANNER.nextLine();
        return input;
    }
}
