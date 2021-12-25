package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import nextstep.ladder.engine.LadderPointGenerateStrategy;
import nextstep.ladder.engine.RailCount;

public class LadderLineBuilder {
    private static final int HEAD_INDEX = 1;
    private static final int LAST_REVERSE_INDEX = 1;

    private final RailCount railCount;
    private final LadderPointGenerateStrategy strategy;
    private final AtomicReference<Point> previous;

    public LadderLineBuilder(RailCount railCount, LadderPointGenerateStrategy strategy) {
        this.railCount = railCount;
        this.strategy = strategy;
        this.previous = new AtomicReference<>(Point.first(strategy.generatePoint()));
    }

    public static LadderLineBuilder of(RailCount railCount, LadderPointGenerateStrategy strategy) {
        if (railCount == null || strategy == null) {
            throw new IllegalArgumentException("rail count or strategy cannot be null");
        }

        return new LadderLineBuilder(railCount, strategy);
    }

    public static LadderLineBuilder of(int railCount, LadderPointGenerateStrategy strategy) {
        return of(LadderRailCount.of(railCount), strategy);
    }

    public List<Point> build() {
        List<Point> points = new ArrayList<>(railCount.toInt());
        points.add(previous.get());
        points.addAll(IntStream.range(HEAD_INDEX, railCount.toInt() - LAST_REVERSE_INDEX)
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
                "sizeOfPerson=" + railCount +
                ", strategy=" + strategy +
                ", previous=" + previous +
                '}';
    }
}
