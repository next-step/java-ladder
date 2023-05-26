package step3.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<String> inputNames() {
        System.out.println("\n참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.nextLine().split(DELIMITER));
    }

    public static List<String> inputResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.nextLine().split(DELIMITER));
    }

    public static int inputLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
