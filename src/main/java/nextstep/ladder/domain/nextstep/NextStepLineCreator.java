package nextstep.ladder.domain.nextstep;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.engine.Line;
import nextstep.ladder.domain.engine.LineCreator;
import nextstep.ladder.domain.strategy.BridgeStrategy;

import java.util.ArrayList;
import java.util.List;

public class NextStepLineCreator implements LineCreator {
    public static final int SECOND_INDEX = 1;

    @Override
    public Line create(int width, BridgeStrategy strategy) {
        Direction first = Direction.first(strategy.makeBridge());
        List<Point> points = new ArrayList<>();
        points.add(Point.first(strategy));

        for (int index = SECOND_INDEX; index < width - 1; index++) {
            first = first.next(strategy.makeBridge());
            points.add(new Point(index, first));
        }
        points.add(new Point(width, first.last(strategy.makeBridge())));
        return new NextStepLine(points);
    }
}
