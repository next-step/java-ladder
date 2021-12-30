package nextstep.ladder.factory;

import nextstep.ladder.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author han
 */
public class LadderFactory {
    private static final int BASE = 1;
    private static final int ZERO = 0;
    private static final int MINIMUM = 2;
    private static final LineStrategy strategy = new RandomStrategy();

    private final Ladder ladder;

    private LadderFactory(Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderFactory from(int width, Height height) {
        return new LadderFactory(Ladder.of(createLines(width, height)));
    }

    public Ladder getLadder() {
        return ladder;
    }

    public static Lines createLines(int width , Height height) {
        int ladderHeight = height.getHeight();

        if (width < MINIMUM) {
            throw new IllegalArgumentException();
        }

        List<Line> lines = IntStream.range(ZERO, ladderHeight)
            .mapToObj(i -> Line.of(createPoints(width)))
            .collect(Collectors.toList());

        return Lines.of(lines);
    }

    public static List<Point> createPoints(int width) {
        List<Point> points = new ArrayList<>();
        points.add(Point.init(strategy.random()));
        for (int i = BASE; i < width; i++) {
            Point point = points.get(i - BASE);
            add(points, point, i == width - 1);
        }
        return points;
    }

    private static void add(List<Point> points, Point point, boolean last) {
        if (last) {
            points.add(point.end());
            return;
        }
        boolean nextBoolean = getNextBoolean(point.isCurrent());
        points.add(point.next(nextBoolean));
    }

    private static boolean getNextBoolean(boolean current) {
        if (current) {
            return false;
        }
        return strategy.random();
    }
}
