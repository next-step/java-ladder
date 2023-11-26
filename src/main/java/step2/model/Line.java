package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Point> points;

    public Line(int playersCount, RandomStrategy randomStrategy) {
        List<Point> result = new ArrayList<>();

        IntStream.range(0, playersCount - 1)
                .forEach(count ->
                        result.add(new Point()
                                .create(isPreviousPointExist(result, count), randomStrategy)));

        this.points = result;
    }

    public Point isPreviousPointExist(List<Point> points, int playerCountIndex) {
        if (playerCountIndex == 0 || points == null) {
            return null;
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
}
