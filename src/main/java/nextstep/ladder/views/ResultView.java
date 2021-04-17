package nextstep.ladder.views;

import nextstep.ladder.*;
import nextstep.ladder.utils.StringUtils;

import java.util.stream.Collectors;

public class ResultView {
    private final static int DISPLAY_BLANK_LENGTH = 5;
    private final static String DIRECTION_DOWN = "|     ";
    private final static String DIRECTION_RIGHT = "|-----";
    private final static String DIRECTION_LEFT = "|     ";
    private final static String RESULT_LADDER_TITLE = "사다리 결과";
    private final static String RESULT_TITLE = "실행 결과";
    private final static String RESULT_SEPARATOR = " : ";
    private final static String BLANK_SEPARATOR = " ";
    private final static String ENTER = System.lineSeparator();

    public static void showPlayersNames(Players players) {
        String stringBuilder = ENTER +
                RESULT_LADDER_TITLE +
                ENTER +
                players.players()
                        .stream()
                        .map(ResultView::getPlayerName)
                        .collect(Collectors.joining(BLANK_SEPARATOR));
        System.out.println(stringBuilder);
    }

    private static String getPlayerName(Player player) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH - player.name().length()) + player.name();
    }

    public static void showLadder(Ladder ladder) {
        String stringBuilder = ladder.ladderLines()
                        .stream()
                        .map(ResultView::getLadderLine)
                        .collect(Collectors.joining(ENTER));
        System.out.println(stringBuilder);
    }

    private static String getLadderLine(LadderLine ladderLine) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH) +
                ladderLine.points()
                        .stream()
                        .map(Point::direction)
                        .map(ResultView::getDisplayDirection)
                        .collect(Collectors.joining());
    }

    private static String getDisplayDirection(Direction direction) {
        if (direction.isRight()) {
            return DIRECTION_RIGHT;
        }
        if (direction.isLeft()) {
            return DIRECTION_LEFT;
        }
        return DIRECTION_DOWN;
    }

    public static void showResultValues(Results results) {
        String stringBuilder = results.values()
                .stream()
                .map(ResultView::getResultValue)
                .collect(Collectors.joining(BLANK_SEPARATOR));
        System.out.println(stringBuilder + ENTER);
    }

    private static String getResultValue(String value) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH - value.length()) + value;
    }

    public static void showPlayerResult(GameResult gameResult) {
        System.out.println(ENTER +
                RESULT_TITLE +
                ENTER +
                gameResult.reward() +
                ENTER);
    }

    public static void showAllResults(GameResults gameResults) {
        System.out.println(ENTER + RESULT_TITLE);
        gameResults.gameResults()
                .forEach(gameResult -> System.out.println(gameResult.name() +
                RESULT_SEPARATOR +
                gameResult.reward()));
    }
}
