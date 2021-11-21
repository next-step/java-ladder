package nextstep.refactor_ladder.domain.generate;

import nextstep.refactor_ladder.domain.Line;
import nextstep.refactor_ladder.domain.value.Point;
import nextstep.refactor_ladder.strategy.LadderStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LineGenerator {
    private static final Integer RANGE_START = 1;

    private LineGenerator() {
        throw new IllegalStateException("직접 생성 금지");
    }

    public static List<Line> create(Integer sizeOfPerson, Integer heightOfLadder, LadderStrategy ladderStrategy) {
        return IntStream.rangeClosed(RANGE_START, heightOfLadder)
                .boxed()
                .map(h -> create(sizeOfPerson, ladderStrategy))
                .collect(Collectors.toList());
    }

    public static Line create(int sizeOfPerson, LadderStrategy ladderStrategy) {
        List<Point> points = new ArrayList<>();
        points.addAll(createFirst(ladderStrategy));
        points.addAll(createMiddle(sizeOfPerson, points.get(0), ladderStrategy));
        points.addAll(createLast(points.get(points.size() - 1)));

        return Line.from(points);
    }

    private static List<Point> createFirst(LadderStrategy ladderStrategy) {
        return Collections.singletonList(Point.first(ladderStrategy.generate()));
    }

    private static List<Point> createMiddle(int sizeOfPerson, Point point, LadderStrategy ladderStrategy) {
        List<Point> points = new ArrayList<>();
        for (int i = RANGE_START; i < sizeOfPerson - 1; i++) {
            point = point.next(ladderStrategy);
            points.add(point);
        }
        return points;
    }

    private static List<Point> createLast(Point point) {
        return Collections.singletonList(point.last());
    }
}
