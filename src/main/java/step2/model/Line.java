package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private static final int PREVIOUS = 0;
    private List<Point> points;

    public Line(int playersCount) {
        List<Point> result = new ArrayList<>();

        IntStream.range(0, playersCount)
                .forEach(count ->
                        result.add(new Point()
                                .create(isPreviousPointExist(result, count), new PointRandomStrategy())));
    }

    public Point isPreviousPointExist(List<Point> points, int playerCountIndex) {
        if (playerCountIndex == 0) {
            return null;
        }

        return points.get(playerCountIndex - PREVIOUS);
    }
}
