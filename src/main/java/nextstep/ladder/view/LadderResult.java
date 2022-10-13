package nextstep.ladder.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Player;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResult {
    private static final String FIRST_ENABLE_POINT = "     |-----";
    private static final String FIRST_DISABLE_POINT = "     |     ";
    private static final String ENABLE_POINT = "|-----";
    private static final String DISABLE_POINT = "|     ";
    private static final String ONE_POINT = "     |";

    private final Ladder ladder;

    public LadderResult(Ladder ladder) {
        this.ladder = ladder;
    }

    public List<String> lines() {
        if (hasOnePlayer()) {
            return List.of(ONE_POINT);
        }

        return ladder.lines()
                .stream()
                .map(this::createLineOfPoints)
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean hasOnePlayer() {
        return ladder.players().count() == 1;
    }

    private String createLineOfPoints(Line line) {
        List<Point> points = line.points();
        return createLineOfPoints(points);
    }

    private String createLineOfPoints(List<Point> points) {
        List<String> line = points.stream()
                .map(this::createPoint)
                .collect(Collectors.toList());

        return String.join("", line);
    }

    private String createPoint(Point point) {
        if (isFirstPoint(point)) {
            return createPoint(point, FIRST_ENABLE_POINT, FIRST_DISABLE_POINT);
        }

        if (isLastPoint(point)) {
            return "|";
        }

        return createPoint(point, ENABLE_POINT, DISABLE_POINT);
    }

    private boolean isFirstPoint(Point point) {
        return point.position() == Point.DEFAULT_POSITION;
    }

    private boolean isLastPoint(Point point) {
        return point.position() == ladder.players().count();
    }

    private String createPoint(Point point, String enabledPoint, String disabledPoint) {
        if (point.isEnable()) {
            return enabledPoint;
        }

        return disabledPoint;
    }

    public List<String> playerNames() {
        return ladder.players()
                .values()
                .stream()
                .map(Player::name)
                .collect(Collectors.toUnmodifiableList());
    }
}
