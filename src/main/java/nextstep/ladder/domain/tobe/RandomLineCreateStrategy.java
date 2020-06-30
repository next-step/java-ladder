package nextstep.ladder.domain.tobe;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomLineCreateStrategy implements LineCreateStrategy {
    private static final Random RAND = new Random();
    private static final List<Direction> cachedFirstDirections = Arrays.asList(Direction.CENTER, Direction.RIGHT);
    private static final List<Direction> cachedBodyDirections = Arrays.asList(Direction.values());
    private static final List<Direction> cachedLastDirections = Arrays.asList(Direction.LEFT, Direction.CENTER);

    @Override
    public Direction first() {
        return cachedFirstDirections.get(RAND.nextInt(cachedFirstDirections.size()));
    }

    @Override
    public Direction body(Direction exDirection) {
        if (exDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return cachedBodyDirections.get(RAND.nextInt(cachedBodyDirections.size()));
    }

    @Override
    public Direction last(Direction exDirection) {
        if (exDirection == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return cachedLastDirections.get(RAND.nextInt(cachedLastDirections.size()));
    }
}
