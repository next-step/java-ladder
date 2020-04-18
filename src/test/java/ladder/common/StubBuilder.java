package ladder.common;

import ladder.ladder.domain.Direction;
import ladder.ladder.domain.Point;

public class StubBuilder {

    public static Point buildStubPoint(int index, boolean left, boolean right) {
        return Point.of(index, Direction.of(left, right));
    }
}
