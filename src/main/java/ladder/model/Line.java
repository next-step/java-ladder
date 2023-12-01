package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(int playersCount, RandomStrategy randomStrategy) {
        List<Point> result = new ArrayList<>();
        IntStream.range(0, playersCount - 1)
                .forEach(count ->
                        result.add(Point.create(isPreviousPointExist(result, count), randomStrategy)));

        return new Line(result);
    }

    public static Point isPreviousPointExist(List<Point> points, int playerCountIndex) {
        if (playerCountIndex == 0 || points.isEmpty()) {
            return new Point();
        }

        return points.get(playerCountIndex - 1);
    }

    @Override
    public String toString() {
        return this.points.stream()
                .map(Point::toString)
                .collect(Collectors.joining());
    }

    public List<Point> getPoints() {
        return this.points;
    }

    public int move(int position) {
        if (Point.isLeftLadderHasPoint(points, position)) {
            return --position;
        }

        if (Point.isStay(points, position)) {
            return position;
        }

        if (Point.isRightLadderHasPoint(points, position)) {
            return ++position;
        }

        return position;
    }
}
