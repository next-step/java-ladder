package nextstep.ladder.view;

import nextstep.ladder.domain.Game;

public class ResultView {

    private static final String REQUEST_PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String REQUEST_WINNING_PRIZE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)\n";
    private static final String REQUEST_LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
    private static final String REQUEST_PLAYER_NAME_FOR_RESULT_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String LADDER_SHAPE_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void requestPlayerNames() {
        System.out.println(REQUEST_PLAYER_NAME_MESSAGE);
    }

    public static void requestWinningPrizes() {
        System.out.println(REQUEST_WINNING_PRIZE_MESSAGE);
    }


    public static void requestLadderHeight() {
        System.out.println(REQUEST_LADDER_HEIGHT_MESSAGE);
    }

    public static void printLadderShape(Game game) {
        System.out.println(LADDER_SHAPE_MESSAGE);
        System.out.println(game);
    }

    public static void requestPlayerNameForResult() {
        System.out.println(REQUEST_PLAYER_NAME_FOR_RESULT_MESSAGE);
    }

    public static void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public static String parseBooleanToDot(boolean input) {
        if (input) {
            return "-----|";
        }
        return "     |";
    }
}
