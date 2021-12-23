package ladder.fixture;

import ladder.domain.*;

import java.util.ArrayList;
import java.util.List;


public class TestLadderFactory {
    public static Players createPlayer(String names) {
        return Players.of(names);
    }

    public static Line createRandomLine(int countOfPlayers) {
        return Line.of(new RandomPoints(countOfPlayers));
    }

    public static Ladder createLadder(String names, int height) {
        return Ladder.of(createPlayer(names), Height.of(height));
    }

    public static List<Point> createPoints(boolean...current) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(current[0]);
        points.add(point);
        for (int i = 1; i < current.length - 1; i++) {
            point = point.next(current[i]);
            points.add(point);
        }
        points.add(point.last());
        return points;
    }

}
