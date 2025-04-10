package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.LadderUsers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private static final int WIDTH = 5;
    private final List<Point> value;

    public static Line createFromLadderUsers(LadderUsers ladderUsers) {
        List<Point> generatedPoints = new ArrayList<>();
        generatedPoints.add(Point.lineRandomPoint(new Point(false)));
        for (int i = 1; i < ladderUsers.getSize() - 1; i++) {
            generatedPoints.add(Point.lineRandomPoint(generatedPoints.get(i - 1)));
        }
        return new Line(generatedPoints);
    }

    public Line(List<Point> points) {
        this.value = points;
    }

    public List<Boolean> getLine() {
        return value.stream().map(Point::isConnected).collect(Collectors.toList());
    }
}
