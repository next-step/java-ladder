package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lines {
    private static final int FIRST_LINE_INDEX = 0;

    private List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Lines(int size, int height) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Point> points = initPoints(i, height);
            lines.add(new Line(points));
        }
    }

    private List<Point> initPoints(int index, int height) {
        List<Point> points = new ArrayList<>();
        for (int j = 0; j < height; j++) {
            Optional<Direction> previousDirection = previousDirection(index - 1, j);
            Direction direction = Direction.getRandomDirection(previousDirection);
            points.add(new Point(direction));
        }
        return points;
    }

    private Optional<Direction> previousDirection(int index, int height) {
        if (index < FIRST_LINE_INDEX) {
            return Optional.empty();
        }

        return Optional.of(getDirection(index, height));
    }

    public int size() {
        return lines.size();
    }

    public Direction getDirection(int index, int height) {
        return lines.get(index).getDirectionOfHeight(height);
    }
}
