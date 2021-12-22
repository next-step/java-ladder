package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLineBuilder {
    private static final int HEAD_INDEX = 1;
    private static final int LAST_REVERSE_INDEX = 1;
    public static final int MINIMUM_RAIL_COUNT = 2;


    private final int sizeOfRail;
    private final LadderPointGenerateStrategy strategy;
    private final AtomicReference<Point> previous;

    public LadderLineBuilder(int sizeOfRail, LadderPointGenerateStrategy strategy) {
        this.sizeOfRail = sizeOfRail;
        this.strategy = strategy;
        this.previous = new AtomicReference<>(Point.first(strategy.generatePoint()));
    }

    public static LadderLineBuilder of(int sizeOfRail, LadderPointGenerateStrategy strategy) {
        if (sizeOfRail < MINIMUM_RAIL_COUNT) {
            throw new IllegalArgumentException("size of rail must larger than or equal to 2");
        }

        if (strategy == null) {
            throw new IllegalArgumentException("strategy cannot be null");
        }

        return new LadderLineBuilder(sizeOfRail, strategy);
    }

    public List<Point> build() {
        List<Point> points = new ArrayList<>(sizeOfRail);
        points.add(previous.get());
        points.addAll(IntStream.range(HEAD_INDEX, sizeOfRail - LAST_REVERSE_INDEX)
                .mapToObj(this::generate)
                .collect(Collectors.toList()));
        points.add(previous.get().last());

        return points;
    }

    private Point generate(int notUsedIndex) {
        return previous.updateAndGet(this::nextPoint);
    }

    private Point nextPoint(Point previousPoint) {
        return previousPoint.next(strategy.generatePoint());
    }

    @Override
    public String toString() {
        return "LadderLineBuilder{" +
                "sizeOfPerson=" + sizeOfRail +
                ", strategy=" + strategy +
                ", previous=" + previous +
                '}';
    }
}
