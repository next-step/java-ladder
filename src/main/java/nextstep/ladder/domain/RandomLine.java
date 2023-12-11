package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLine {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static List<Point> makeRandomLine(int numberOfParticipants) {;
        List<Point> points = new ArrayList<>();
        points.add(new Point(random.nextBoolean()));
        for (int index=1; index<numberOfParticipants-1; index++) {
            points.add(makeRandomPoint(points,index-1));
        }
        return points;
    }

    private static Point makeRandomPoint(List<Point> points, int index) {
        if (points.get(index).getIsStair()) {
            return new Point(false);
        }
        return new Point(random.nextBoolean());
    }
}
