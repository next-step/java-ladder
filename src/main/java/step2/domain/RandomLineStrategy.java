package step2.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineStrategy implements LineStrategy {
    private final Random random = new Random();
    private Direction previousLadder;

    @Override
    public List<Direction> createLine(int personCount) {
        previousLadder = Direction.DOWN;
        return IntStream.range(0, personCount)
                .mapToObj(position -> randomLine(position, personCount))
                .collect(Collectors.toList());
    }

    private Direction randomLine(int position, int personCount) {

        if (previousLadder == Direction.RIGHT) {
            previousLadder = Direction.LEFT;
            return previousLadder;
        }
        if (previousLadder == Direction.LEFT) {
            previousLadder = Direction.DOWN;
            return previousLadder;
        }
        if (random.nextBoolean() && personCount - 1 != position) {
            previousLadder = Direction.RIGHT;
            return previousLadder;
        }
        previousLadder = Direction.DOWN;
        return previousLadder;
    }

}
