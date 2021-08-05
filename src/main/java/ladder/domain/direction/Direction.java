package ladder.domain.direction;

import ladder.core.DirectionGenerator;
import ladder.factory.LadderFactoryBean;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ladder.domain.direction.DirectionValue.*;

public final class Direction {
    private final DirectionValue value;

    private Direction(final DirectionValue value) {
        this.value = value;
    }

    public static Direction of(final DirectionValue value) {
        return InnerLazyClass.CACHED.get(value);
    }

    public static Direction first() {
        return InnerLazyClass.GENERATOR.first();
    }

    public Direction last() {
        return InnerLazyClass.GENERATOR.last(this);
    }

    public Direction next() {
        return InnerLazyClass.GENERATOR.next(this);
    }

    public boolean isEmpty() {
        return value == EMPTY;
    }

    public boolean isLeft() {
        return value == LEFT;
    }

    public boolean isRight() {
        return value == RIGHT;
    }

    @Override
    public boolean equals(final Object compareValue) {
        if (this == compareValue) {
            return true;
        }
        if (compareValue == null || getClass() != compareValue.getClass()) {
            return false;
        }
        final Direction direction = (Direction) compareValue;
        return value == direction.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static class InnerLazyClass {
        private static final Map<DirectionValue, Direction> CACHED =
                Stream.of(values())
                        .collect(Collectors.toMap(
                                iDirectionValue -> iDirectionValue, Direction::new
                        ));

        private static final DirectionGenerator GENERATOR = LadderFactoryBean.directionGenerator();
    }
}
