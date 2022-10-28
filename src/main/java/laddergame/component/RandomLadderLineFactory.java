package laddergame.component;

import laddergame.domain.Direction;
import laddergame.domain.LadderLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLadderLineFactory implements LadderLineFactory {

    private static final Random RANDOM = new Random();

    @Override
    public LadderLine createLadderLine(int numberOfPoints) {
        validate(numberOfPoints);

        List<Direction> directions = createDirections(numberOfPoints);
        assert directions != null;
        return LadderLine.from(directions.toArray(new Direction[0]));
    }

    private static void validate(int numberOfPoints) {
        if (numberOfPoints < LadderLine.MIN_NUMBER_OF_POINTS) {
            throw new IllegalArgumentException(String.format("포인트의 개수는 최소 %d 개 이상이어야 합니다.", LadderLine.MIN_NUMBER_OF_POINTS));
        }
    }

    private List<Direction> createDirections(int numberOfDirections) {
        if (numberOfDirections == 0) {
            return Collections.emptyList();
        }
        if (numberOfDirections == LadderLine.MIN_NUMBER_OF_POINTS) {
            return List.of(Direction.NONE);
        }
        return createRandomDirections(numberOfDirections);
    }

    private List<Direction> createRandomDirections(int numberOfDirections) {
        List<Direction> directions = new ArrayList<>();
        directions.add(createRightOrNoneDirection());
        IntStream.range(1, numberOfDirections - 1)
                .forEach(i -> directions.add(directions.get(i - 1) == Direction.RIGHT ? Direction.LEFT : createRightOrNoneDirection()));
        directions.add(directions.get(directions.size() - 1) == Direction.RIGHT ? Direction.LEFT : Direction.NONE);
        return directions;
    }

    private Direction createRightOrNoneDirection() {
        return RANDOM.nextBoolean() ? Direction.RIGHT : Direction.NONE;
    }

}
