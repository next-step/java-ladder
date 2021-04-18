package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static String GET_TOP = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String GET_BOTTOM = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final static String GET_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final static String FIND_RESULT = "결과를 보고 싶은 사람은?";

    private final static Scanner scanner = new Scanner(System.in);

    public static List<String> getTop() {
        System.out.println(GET_TOP);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static List<String> getBottom() {
        System.out.println(GET_BOTTOM);
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static int getLadderHeight() {
        System.out.println(GET_LADDER_HEIGHT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String findResult() {
        System.out.println(FIND_RESULT);
        return scanner.nextLine();
    }

}
