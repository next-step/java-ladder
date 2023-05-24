package nextstep.ladder.domain.nextstep;

import nextstep.ladder.domain.engine.Line;
import nextstep.ladder.domain.engine.LineCreator;
import nextstep.ladder.domain.strategy.BridgeStrategy;

import java.util.ArrayList;
import java.util.List;

public class NextStepLineCreator implements LineCreator {
    public static final int SECOND_INDEX = 1;

    @Override
    public Line create(int width, BridgeStrategy strategy) {
        List<Point> points = new ArrayList<>();
        Direction first = Direction.first(strategy.makeBridge());
        points.add(Point.first(first));

        for (int index = SECOND_INDEX; index < width-1; index++) {
            first = first.next(strategy.makeBridge());
            points.add(new Point(index, first));
        }
        points.add(new Point(width - 1, first.last()));
        return new NextStepLine(points);

    }
}
