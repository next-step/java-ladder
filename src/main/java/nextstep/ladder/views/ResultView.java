package nextstep.ladder.views;

import nextstep.ladder.domain.*;
import nextstep.ladder.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private final static int DISPLAY_BLANK_LENGTH = 5;
    private final static String RESULT_TITLE = "실행 결과";
    private final static String RESULT_SEPARATOR = " : ";
    private final static String BLANK_SEPARATOR = " ";
    private final static String ENTER = System.lineSeparator();

    public static void showLadder(GameResult result) {
        String stringBuilder = ENTER +
                "사다리 결과" +
                ENTER +
                getPlayersNames(result.playerNames()) +
                ENTER +
                getLadder(result.ladderLines()) +
                ENTER +
                getResultValues(result.resultValues())
                ;
        System.out.println(stringBuilder);
    }

    private static String getPlayersNames(List<String> names) {
        return names.stream()
                .map(ResultView::getPlayerName)
                .collect(Collectors.joining(BLANK_SEPARATOR));
    }

    private static String getPlayerName(String name) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH - name.length()) + name;
    }

    private static String getLadder(List<Line> lines) {
        return lines.stream()
                .map(ResultView::getLine)
                .collect(Collectors.joining(ENTER));
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

    private static String getResultValues(List<String> values) {
        return values.stream()
                .map(ResultView::getResultValue)
                .collect(Collectors.joining(BLANK_SEPARATOR));
    }

    private static String getResultValue(String value) {
        return StringUtils.generateBlank(DISPLAY_BLANK_LENGTH - value.length()) + value;
    }

    public static void showPlayerResult(GameResult result, String name) {
        Player player = result.player(name);
        System.out.println(ENTER + RESULT_TITLE);
        System.out.println(result.playerResult(player.position()));
    }

    public static void showAllResults(GameResult result) {
        System.out.println(ENTER + RESULT_TITLE);
        result.players()
                .forEach(player -> System.out.println(player.name() +
                        RESULT_SEPARATOR +
                        result.ladderResult(player.position())));
    }
}
