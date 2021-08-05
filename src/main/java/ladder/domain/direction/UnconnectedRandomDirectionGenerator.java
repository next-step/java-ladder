package ladder.domain.direction;

import ladder.core.DirectionGenerator;

import java.util.Random;

import static ladder.domain.direction.DirectionValue.*;

public class UnconnectedRandomDirectionGenerator implements DirectionGenerator {
    private static final Random random = new Random();

    @Override
    public Direction next(final Direction current) {
        if (current.isRight()) { // 오른쪽으로 열린 줄을 닫아준다.
            return Direction.of(LEFT);
        }
        if (current.isLeft()) { // 이어지지 않게 한다.
            return Direction.of(EMPTY);
        }

        // EMPTY 이거나, 오른쪽으로 열거나
        DirectionValue directionValue =
                random.nextBoolean() ? EMPTY : RIGHT;
        return Direction.of(directionValue);
    }

    @Override
    public Direction first() {
        return Direction.of(
                random.nextBoolean() ? RIGHT : EMPTY
        );
    }

    @Override
    public Direction last(Direction current) {
        return Direction.of(
                current.isRight() ? LEFT : EMPTY
        );
    }
}
