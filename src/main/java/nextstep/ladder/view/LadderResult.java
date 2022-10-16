package nextstep.ladder.view;

import nextstep.ladder.domain.Game;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderResult {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String POINT = "|";
    private static final String ENABLE_RIGHT_POINT = "-----";
    private static final String DISABLE_RIGHT_POINT = "     ";

    private final Game game;
    private final String[] results;

    public LadderResult(Game game, String[] results) {
        this.game = game;
        this.results = results;
    }

    public String playerNames() {
        return game.resultTable()
                .keySet()
                .stream()
                .map(player -> String.format("%6s", player.name()))
                .collect(Collectors.joining());
    }

    public String ladder() {
        List<String> lines = createLines(game.ladder().lines());
        return String.join(NEW_LINE, lines);
    }

    private List<String> createLines(List<Line> lines) {
        return lines.stream()
                .map(this::createLineOfPoints)
                .collect(Collectors.toList());
    }

    private String createLineOfPoints(Line line) {
        List<Point> points = line.points();

        StringBuilder result = new StringBuilder();
        result.append(DISABLE_RIGHT_POINT);
        for (Point point : points) {
            addPoint(result, point);
        }

        return result.toString();
    }

    private void addPoint(StringBuilder result, Point point) {
        result.append(POINT);

        if (point.hasRight()) {
            result.append(ENABLE_RIGHT_POINT);
            return;
        }

        result.append(DISABLE_RIGHT_POINT);
    }

    public String results() {
        return Stream.of(results)
                .map(result -> String.format("%6s", result))
                .collect(Collectors.joining());
    }
}
