package nextstep.ladder.views;

import nextstep.ladder.utils.StringUtils;

import java.util.Scanner;

public class InputView {
    private final static String PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final static String LADDER_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final static String LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    private final static String CHOICE_PLAYER = "결과를 보고 싶은 사람은?";
    private final static Scanner scanner = new Scanner(System.in);

    private InputView() { }

    private static void emptyValidation(String value) {
        if (StringUtils.isEmpty(value))
            throw new IllegalArgumentException("유효하지 않은 입력값 입니다.");
    }

    private static String value(String description) {
        System.out.println(description);
        String value = scanner.nextLine();
        emptyValidation(value);
        return value;
    }

    public static String playerNames() {
        return value(PLAYER_NAMES);
    }

    public static String ladderResults() {
        return value(LADDER_RESULTS);
    }

    public static String ladderHeight() {
        return value(LADDER_HEIGHT);
    }

    public static String choicePlayer() {
        return value(CHOICE_PLAYER);
    }
}
