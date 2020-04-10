package ladder.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static String ALL_GAMERS = "all";
    private static final String GET_GAMER_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String GET_HEIGHT_MSG = "최대 사다리 높이는 몇 개 인가요?";
    private static final String GET_RESULT_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String GET_EXPECT_RESULT_MSG = "결과를 보고 싶은 사람은?";
    private static final String COMMA = ",";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> getGamers() {
        System.out.println(GET_GAMER_MSG);
        return arrayToTrimmedList(scanner.nextLine().split(COMMA));
    }

    public int getHeight() {
        System.out.println(GET_HEIGHT_MSG);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> getLadderResults() {
        System.out.println(GET_RESULT_MSG);
        return arrayToTrimmedList(scanner.nextLine().split(COMMA));
    }

    public String getExpectResult() {
        System.out.println(GET_EXPECT_RESULT_MSG);
        return scanner.nextLine();
    }

    private List<String> arrayToTrimmedList(String[] array) {
        return Arrays.stream(array)
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
