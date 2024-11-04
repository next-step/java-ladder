package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderGenerator implements LadderGenerator {

    private static final Random random = new Random();

    @Override
    public MyLadder generateLadder(int participantCount, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(createRandomLine(participantCount));
        }
        return new MyLadder(lines);
    }

    private Line createRandomLine(int participantCount) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(random.nextBoolean());
        points.add(point);
        for (int cnt = 1; cnt < participantCount - 1; cnt++) {
            point = point.next(random.nextBoolean());
            points.add(point);
        }
        points.add(point.last());
        return new Line(points);
    }
}
