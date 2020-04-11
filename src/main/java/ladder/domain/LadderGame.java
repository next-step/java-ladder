package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.Direction.DOWN;

public class LadderGame {

    private static final Random random = new Random();

    private final Map<Integer, Integer> resultCache;
    private final Ladder ladder;

    public LadderGame(int width, int height) {
        this.ladder = generateLadder(width, height);
        this.resultCache = new HashMap<>();
    }

    private Ladder generateLadder(int width, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> this.generateLine(width))
                .collect(Collectors.toList());

        return Ladder.of(lines);
    }

    private Line generateLine(int width) {
        List<Point> points = new ArrayList<>();
        points.add(Point.in(0));

        for (int i = 1; i < width; i++) {
            Point right = Point.in(i);
            Point left = points.get(i - 1);
            connectPointRandomly(left, right);
            points.add(right);
        }

        return Line.of(points);
    }

    private void connectPointRandomly(Point left, Point right) {
        if (!random.nextBoolean() || !left.isConnectedTo(DOWN)) {
            return;
        }
        left.connect(right);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public int result(int idx) {
        if (resultCache.containsKey(idx)) {
            return resultCache.get(idx);
        }

        int resultIdx = ladder.down(idx);
        resultCache.put(idx, resultIdx);

        return resultIdx;
    }
}
