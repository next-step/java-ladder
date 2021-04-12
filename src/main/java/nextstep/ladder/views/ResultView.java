package nextstep.ladder.views;

import nextstep.ladder.domain.*;
import nextstep.ladder.domain.generator.Line;
import nextstep.ladder.domain.generator.Point;
import nextstep.ladder.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final static int DISPLAY_BLANK_LENGTH = 5;
    private final static String RESULT_TITLE = "실행 결과";
    private final static String RESULT_SEPARATOR = " : ";
    private final static String BLANK_SEPARATOR = " ";
    private final static String ENTER = System.lineSeparator();

    public static void showPlayersNames(List<String> names) {
        String stringBuilder = ENTER +
                "사다리 결과" +
                ENTER +
                names.stream()
                        .map(ResultView::getPlayerName)
                        .collect(Collectors.joining(BLANK_SEPARATOR));
        System.out.println(stringBuilder);
    }

    private static String getPlayerName(String name) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH - name.length()) + name;
    }

    public static void showLadder(List<Line> lines) {
        String stringBuilder = ENTER +
                lines.stream()
                        .map(ResultView::getLine)
                        .collect(Collectors.joining(ENTER));
        System.out.println(stringBuilder);
    }

    private static String getLine(Line line) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH) +
                line.points()
                        .stream()
                        .map(Point::direction)
                        .map(ResultView::getDisplayDirection)
                        .collect(Collectors.joining());
    }

    private static String getDisplayDirection(Direction direction) {
        return DisplayDirection.valueOf(direction.toString())
                .displayChar;
    }

    public static void showResultValues(List<String> values) {
        String stringBuilder = values.stream()
                .map(ResultView::getResultValue)
                .collect(Collectors.joining(BLANK_SEPARATOR));
        System.out.println(stringBuilder);
    }

    private static String getResultValue(String value) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH - value.length()) + value;
    }

    public static void showPlayerResult(GameResult result) {
        System.out.println(ENTER + RESULT_TITLE);
        System.out.println(result.reward());
    }

    public static void showAllResults(List<GameResult> gameResults) {
        System.out.println(ENTER + RESULT_TITLE);
        gameResults.forEach(gameResult -> System.out.println(gameResult.name() +
                RESULT_SEPARATOR +
                gameResult.reward()));
    }
}
