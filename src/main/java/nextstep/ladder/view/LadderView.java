package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Players;

import java.util.List;
import java.util.stream.Collectors;

public class LadderView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String POINT = "|";
    private static final String ENABLE_RIGHT_POINT = "-----";
    private static final String DISABLE_RIGHT_POINT = "     ";

    private final Players players;
    private final Ladder ladder;

    public LadderView(Ladder ladder, Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public String getPlayerNames() {
        return players.values()
                .stream()
                .map(p -> String.format("%6s", p.name()))
                .collect(Collectors.joining());
    }

    public String getLadder() {
        return String.join(NEW_LINE, createLines(ladder.lines()));
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
}
