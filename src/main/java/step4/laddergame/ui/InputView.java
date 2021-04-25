package step4.laddergame.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_WANT_NAME = "결과를 보고 싶은 사람은? (개인 혹은 all 입력)";
    private static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    public static List<String> inputNames() {
        System.out.println(INPUT_NAMES);
        return inputStr();
    }

    public static List<String> inputResults() {
        System.out.println(INPUT_RESULTS);
        return inputStr();
    }

    public static int inputHeight() {
        System.out.println(INPUT_HEIGHT);
        return Integer.parseInt(sc.nextLine());
    }

    public static String inputWantName() {
        System.out.println(INPUT_WANT_NAME);
        return sc.nextLine();
    }

    private static List<String> inputStr() {
        String input = sc.nextLine();
        return Arrays.asList(input.split(","));
    }

    public static void close() {
        sc.close();
    }
}
