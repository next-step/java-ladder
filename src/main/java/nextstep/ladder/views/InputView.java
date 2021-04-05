package nextstep.ladder.views;

import nextstep.ladder.utils.StringUtils;

import java.util.Scanner;

public class InputView {
    private final static String PLAYERS_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String MAX_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?";
    private final static String GAME_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final static String CHOOSE_PLAYER_RESULT = "결과를 보고 싶은 사람은?";

    private InputView() { }

    private static void emptyValidation(String value) {
        if (StringUtils.isEmpty(value))
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다.");
    }

    private static String value(String description) {
        System.out.println(description);
        String value = new Scanner(System.in).nextLine();
        emptyValidation(value);
        return value;
    }

    public static String playerNames() {
        return value(PLAYERS_NAME);
    }

    public static int maxLadderLength() {
        return Integer.parseInt(value(MAX_LADDER_LENGTH));
    }

    public static String gameResults() {
        return value(GAME_RESULT);
    }

    public static String choosePlayerResult() {
        return value(CHOOSE_PLAYER_RESULT);
    }
}
