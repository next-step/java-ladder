package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LadderLine {
    public static final int MIN_LADDER_SIZE = 2;
    private List<Point> points;

    private LadderLine(int ladderSize) {
        if (ladderSize < MIN_LADDER_SIZE) {
            throw new IllegalArgumentException("ladderSize 는 " + ladderSize + "보다 커야합니다.");
        }
        this.points = new ArrayList<>();
    }

    public static LadderLine init(int ladderSize) {
        LadderLine ladderLine = new LadderLine(ladderSize);
        ladderLine.initFirst();
        ladderLine.initBody(ladderSize);
        ladderLine.initLast();
        return ladderLine;
    }

    public static LadderLine of(List<Point> points) {
        LadderLine ladderLine = new LadderLine(points.size());
        ladderLine.points = points;
        return ladderLine;
    }

    public int size() {
        return points.size();
    }

    public int move(int index) {
        return points.get(index).move();
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    private void initFirst() {
        Point first = Point.first(RandomGenerator.randomBoolean());
        points.add(first);
    }

    private void initLast() {
        Point last = points.get(points.size() - 1).last();
        points.add(last);
    }

    private void initBody(int ladderSize) {
        IntStream.range(0, ladderSize - 2)
                .forEach((index) -> {
                    Point nextPoint = points.get(index).next();
                    points.add(nextPoint);
                });
    }
}
