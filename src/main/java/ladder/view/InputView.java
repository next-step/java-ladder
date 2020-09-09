package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES_PHRASE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_PRIZES_PHRASE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_WIDTH_PHRASE = "최대 사다리 높이는 몇 개인가요?";
    private static final String RESULT_QUERY_PHRASE = "결과를 보고 싶은 사람은?";
    private static final String DELIMITER_STRING = ",";
    private static final String BLANK_STRING = " ";
    private static final String EMPTY_STRING = "";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> getUserNames() {
        System.out.println(INPUT_NAMES_PHRASE);
        return getElements();
    }

    public static int getHeight() {
        System.out.println(LADDER_WIDTH_PHRASE);
        String height = scanner.nextLine();

        return Integer.parseInt(height);
    }

    public static List<String> getPrizeNames() {
        System.out.println(INPUT_PRIZES_PHRASE);
        return getElements();
    }

    public static String getResultUserName() {
        System.out.println();
        System.out.println(RESULT_QUERY_PHRASE);
        return scanner.nextLine();
    }

    private static List<String> getElements() {
        String elements = scanner.nextLine();
        return Arrays.asList(elements.replaceAll(BLANK_STRING, EMPTY_STRING)
                .split(DELIMITER_STRING));
    }

}
