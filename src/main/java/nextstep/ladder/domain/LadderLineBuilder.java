package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

import nextstep.ladder.engine.LadderPointGenerateStrategy;
import nextstep.ladder.engine.RailCount;

public class LadderLineBuilder {
    private static final int HEAD_INDEX = 1;
    private static final int LAST_REVERSE_INDEX = 1;

    private final RailCount railCount;
    private final LadderPointGenerateStrategy strategy;

    public LadderLineBuilder(RailCount railCount, LadderPointGenerateStrategy strategy) {
        this.railCount = railCount;
        this.strategy = strategy;
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

    public LadderLine build() {
        List<Point> points = new ArrayList<>(railCount.toInt());
        Point previous = Point.first(strategy.generatePoint());
        points.add(previous);
        for (int index = HEAD_INDEX; index < railCount.toInt() - LAST_REVERSE_INDEX; index++) {
            previous = previous.next(strategy.generatePoint());
            points.add(previous);
        }
        points.add(previous.last());

        return LadderLine.of(points);
    }

    @Override
    public String toString() {
        return "LadderLineBuilder{" +
                "sizeOfPerson=" + railCount +
                ", strategy=" + strategy +
                '}';
    }
}
