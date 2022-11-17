package ladder.strategy;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STRAIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import ladder.domain.Direction;

public class RandomLinkStrategy implements LinkStrategy {

    private final static Random random = new Random();

    @Override
    public List<Direction> link(final int column) {
        List<Direction> result = new ArrayList<>();
        IntStream.range(0, column)
            .mapToObj(i -> nextDirection(i, column - 1, result))
            .forEach(result::add);

        return result;
    }

    private Direction nextDirection(final int index, final int last, final List<Direction> linked) {
        if (index != 0 && isAlreadyLinked(index, linked)) {
            return LEFT;
        }

        if (index != last && random.nextBoolean()) {
            return RIGHT;
        }

        return STRAIGHT;
    }

    private boolean isAlreadyLinked(final int index, final List<Direction> linked) {
        return linked.get(index - 1) == RIGHT;
    }
}
