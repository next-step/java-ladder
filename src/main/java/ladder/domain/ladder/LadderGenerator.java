package ladder.domain.ladder;

import ladder.vo.LadderSize;
import ladder.vo.Length;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
    private static final Random RANDOM = new Random();

    private LadderGenerator() {
    }

    static Ladder generateLadder(LadderSize ladderSize) {
        Length width = ladderSize.getWidth();
        Length height = ladderSize.getHeight();

        List<Line> lines = IntStream.range(0, height.getValue())
                .mapToObj(i -> makeLine(width))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    static Line makeLine(Length width) {
        int lineWidth = width.getValue();

        List<Point> points = new ArrayList<>(lineWidth);
        points.add(new Point(RANDOM.nextBoolean()));

        for (int i = 0; i < lineWidth - 1; i++) {
            Point point = points.get(i);

            Point nextPoint = getNextPoint(point);
            points.add(nextPoint);
        }

        return new Line(points);
    }

    private static Point getNextPoint(Point point) {
        return point.isCross() ? new Point(false) : new Point(RANDOM.nextBoolean());
    }
}
