package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String STANDARD_REGEX = ",";

    public static List<String> nextPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String peopleString = SCANNER.nextLine();
        if (peopleString == null || peopleString.isEmpty()) {
            throw new IllegalArgumentException("참여할 사람 이름이 없습니다.");
        }
        return Arrays.asList(peopleString.split(STANDARD_REGEX));
    }

    public static List<String> nextResult() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String resultString = SCANNER.nextLine();
        if (resultString == null || resultString.isEmpty()) {
            throw new IllegalArgumentException("실행 결과가 없습니다.");
        }
        return Arrays.asList(resultString.split(STANDARD_REGEX));
    }

    public static int nextHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }

    public static void nextLine() {
        SCANNER.nextLine();
    }

    public static String nextWantedName() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return SCANNER.nextLine();
    }
}
