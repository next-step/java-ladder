package nextstep.ladder;

import static nextstep.ladder.PointType.EMPTY;
import static nextstep.ladder.PointType.HORIZONTAL_LINE;

public class RandomLinePointGenerator implements PointGenerator {

    @Override
    public Point create() {
        return new Point(getRandomlyType());
    }

    private PointType getRandomlyType() {
        return Math.random() < 0.5 ? HORIZONTAL_LINE : EMPTY;
    }
}
