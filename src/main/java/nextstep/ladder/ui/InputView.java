package nextstep.ladder.ui;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String USER_NAMES_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GAME_RESULT_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_QUESTION = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String SPLIT_DELIMITER = ",";

    private InputView() {
        throw new UnsupportedOperationException("인스턴스를 생성할 수 없습니다.");
    }

    public static Set<String> readUserNames() {
        System.out.println(USER_NAMES_QUESTION);
        return Arrays.stream(readText().split(SPLIT_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static int readLadderHeight() {
        System.out.println(LADDER_HEIGHT_QUESTION);
        return readInt();
    }

    private static String readText() {
        return SCANNER.nextLine();
    }

    private static int readInt() {
        int num = SCANNER.nextInt();
        SCANNER.nextLine();
        return num;
    }

    public static List<String> readGameResult() {
        System.out.println(GAME_RESULT_QUESTION);
        return Arrays.stream(readText().split(SPLIT_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
