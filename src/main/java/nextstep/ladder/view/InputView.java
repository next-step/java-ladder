package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
    private final static String SPLIT_DELIMITER = ",";
    private final static String REQUEST_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String REQUEST_HEIGHT_COUNT = "최대 사다리 높이는 몇 개인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public static String[] requestNames() {
        System.out.println(REQUEST_NAMES);
        return split(scanner.nextLine());
    }

    private static String[] split(String text) {
        return text.split(SPLIT_DELIMITER);
    }

    public static int requestHeightCount() {
        System.out.println(REQUEST_HEIGHT_COUNT);
        return scanner.nextInt();
    }
}
