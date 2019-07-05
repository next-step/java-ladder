package ladderGame.util;

import ladderGame.domain.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomDirectionGenerator implements DirectionGenerator {

    private final static int ALL_DIRECTION = 3;
    private final static int EXCEPT_LEFT_DIRECTION = 2;

    private Random random = new Random();
    private List<Direction> directions = new ArrayList<>();

    @Override
    public List<Direction> generate(int count) {
        IntStream.range(0, count)
                .forEach(index -> directions.add(randomDirection(getPreviousDirection())));
        return null;
    }

    private Direction getPreviousDirection() {
        if (directions.isEmpty()) {
            return Direction.of(getRandom(ALL_DIRECTION));
        }
        return directions.get(directions.size() - 1);
    }

    private Direction randomDirection(Direction previousDirection) {
        if (previousDirection == Direction.RIGHT1) {
            return Direction.of(getRandom(ALL_DIRECTION));
        }
        return Direction.of(getRandom(EXCEPT_LEFT_DIRECTION));
    }

    private int getRandom(int count) {
        return random.nextInt(count);
    }
}
