package ladder.view;

import java.util.List;
import java.util.Scanner;
import ladder.domain.exception.IntegerMismatchException;

public class InputView {

    private static final String DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitString();
    }

    public static List<String> getRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return splitString();
    }

    public static String getResultName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return getString();
    }

    private static List<String> splitString() {
        return List.of(getString().split(DELIMITER));
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return getInt();
    }

    private static int getInt() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            throw new IntegerMismatchException();
        }
    }

    private static String getString() {
        return scanner.nextLine();
    }

    public static void clear() {
        scanner.nextLine();
    }
}
