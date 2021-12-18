package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class InputView {

    private static final String COMMA = ",";
    private static final String INPUT_COUNT_OF_PLAYERS = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요) ";
    private static final String INPUT_ITEMS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_FIND_PLAYER_RESULT = "결과를 보고 싶은 사람은?";
    public static final String ERROR_INVALID_VALUE_MSG = "잘못된 입력 값 입니다.";

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static List<String> printInputNames() {
        System.out.println(INPUT_COUNT_OF_PLAYERS);
        return Arrays.asList(sc.nextLine().split(COMMA));
    }

    public static List<String> printInputItems() {
        System.out.println(INPUT_ITEMS);
        return Arrays.asList(sc.nextLine().split(COMMA));
    }

    public static int printInputLadderHeight() {
        System.out.println(INPUT_LADDER_HEIGHT);
        return Integer.parseInt(sc.nextLine());
    }

    public static String printInputFindPlayer() {
        System.out.println(INPUT_FIND_PLAYER_RESULT);
        return checkInvalidValue(sc.nextLine());
    }

    private static String checkInvalidValue(String inputValue) {
        if (Objects.isNull(inputValue) || inputValue.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_VALUE_MSG);
        }
        return inputValue;
    }

}
