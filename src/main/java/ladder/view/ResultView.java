package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.PlayerName.DEFAULT_MAX_NAME_LENGTH;

public class ResultView {
    public static final int START_INCLUSIVE = 0;
    public static final String LINE_BREAK = System.lineSeparator();
    public static final String SPACE = " ";
    public static final String SPACES = "     ";
    public static final String CROSS_LINES = "-----";
    public static final String PLAYER_DELIMITER = "|";
    public static final String PREFIX = "";
    public static final int INDEX_OFFSET = 1;
    public static final String RESULT_MESSAGE = "실행결과";

    public ResultView() {
    }

    public void renderLadder(Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(toLadderString(ladder));
    }

    public String toLadderString(Ladder ladder) {
        Players players = ladder.getPlayers();
        List<Line> lines = ladder.getLines()
                .getLines();
        return toFormattedNames(players) +
                LINE_BREAK +
                toFormattedLines(players, lines);
    }

    private static String toFormattedLines(Players players, List<Line> lines) {
        return lines.stream()
                .map(line -> toFormattedLine(players, line.getPoints()))
                .collect(Collectors.joining(LINE_BREAK));
    }

    private static String toFormattedNames(Players players) {
        return players.names()
                .stream()
                .map(name -> SPACE.repeat(DEFAULT_MAX_NAME_LENGTH - name.length()) + name.name())
                .collect(Collectors.joining(SPACE));
    }

    private static String toFormattedLine(Players players, List<Point> points) {
        List<PlayerName> playerNames = players.names();
        return IntStream.range(START_INCLUSIVE, playerNames.size())
                .boxed()
                .map(index -> toFormattedHorizontal(index, points))
                .collect(Collectors.joining(PLAYER_DELIMITER, PREFIX, PLAYER_DELIMITER));
    }

    private static String toFormattedHorizontal(int index, List<Point> points) {
        if (index == START_INCLUSIVE) {
            return SPACES;
        }
        if (points.get(index - INDEX_OFFSET).getCurrent()) {
            return CROSS_LINES;
        }
        return SPACES;
    }
}
