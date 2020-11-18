package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {
    private static final double PROBABILTY_HAVING_POINT = 0.5;
    private final List<Boolean> points;
    private final int width;

    public LadderLine(List<Boolean> points) {
        this.points = points;
        this.width = points.size();
    }

    public static LadderLine of(List<Boolean> points) {
        return new LadderLine(points);
    }

    public static LadderLine ofWidth(int width) {
        Stream<Boolean> pointsStream = Stream.iterate(false, LadderLine::getPoint);
        return new LadderLine(createPoints(width, pointsStream));
    }

    private static List<Boolean> createPoints(int width, Stream<Boolean> pointsStream) {
        return pointsStream.limit(width)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    private static Boolean getPoint(Boolean hasPrevPoint) {
        if (hasPrevPoint) {
            return false;
        }
        return getRandomPoint();
    }

    private static Boolean getRandomPoint() {
        return Math.random() > PROBABILTY_HAVING_POINT;
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }


    public int followFrom(int point) {
        if (canFollowLeft(point)) {
            return point - 1;
        }
        if (canFollowRight(point)) {
            return point + 1;
        }
        return point;
    }

    private boolean canFollowLeft(int point) {
        return points.get(point);
    }

    private boolean canFollowRight(int point) {
        int rightPoint = point + 1;
        return rightPoint < width && points.get(rightPoint);
    }

    public int getWidth() {
        return width;
    }
}
