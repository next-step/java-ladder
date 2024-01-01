package nextstep.ladder.factory;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.strategy.RandomGeneratePointStrategy;

public class LineCreator {

    public Line create(int size) {
        RandomGeneratePointStrategy strategy = new RandomGeneratePointStrategy(size);
        return new Line(strategy);
    }
}
