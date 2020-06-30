package nextstep.ladder.domain.ladders;

import nextstep.ladder.common.Direction;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomLineCreateStrategy implements LineCreateStrategy {
    private static final Random RAND = new Random();
    private static final List<Direction> cachedDirections = Arrays.asList(Direction.CENTER, Direction.RIGHT);

    @Override
    public Direction first() {
        return cachedDirections.get(RAND.nextInt(cachedDirections.size()));
    }

    @Override
    public Direction body(Direction exDirection) {
        if (exDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return cachedDirections.get(RAND.nextInt(cachedDirections.size()));
    }

    @Override
    public Direction last(Direction exDirection) {
        if (exDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.CENTER;
    }
}
