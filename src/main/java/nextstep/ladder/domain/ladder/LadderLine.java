package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static nextstep.ladder.util.RandomRightDirectionGenerator.hasRight;

public class LadderLine {
    private final List<Point> points;
    private final int width;

    public LadderLine(List<Point> points) {
        this.points = points;
        this.width = points.size();
    }

    public static LadderLine of(List<Boolean> hasLefts) {
        int width = hasLefts.size();
        return new LadderLine(createPoints(hasLefts, width));
    }

    private static List<Point> createPoints(List<Boolean> hasLefts, int width) {
        return IntStream.range(0, width)
                .mapToObj(currentPosition -> getPoint(hasLefts, width, currentPosition))
                .collect(Collectors.toList());
    }

    private static Point getPoint(List<Boolean> hasLefts, int width, int currentPosition) {
        Position position = Position.of(currentPosition, getMaxPosition(width));
        Boolean hasLeft = hasLefts.get(currentPosition);
        if (position.isLast()) {
            return Point.of(position, Direction.last(hasLeft));
        }
        return Point.of(position, Direction.of(hasLeft, hasLefts.get(currentPosition + 1)));
    }

    private static int getMaxPosition(int width) {
        return width - 1;
    }

    public static LadderLine ofWidth(int width) {
        Stream<Point> pointsStream = Stream.iterate(Point.first(getMaxPosition(width), hasRight()), point -> point.next(hasRight()));
        return new LadderLine(createPoints(width, pointsStream));
    }

    private static List<Point> createPoints(int width, Stream<Point> pointsStream) {
        return pointsStream.limit(width)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    public int followFrom(int position) {
        return points.get(position).move();
    }

    public int getWidth() {
        return width;
    }
}
