package ladder.domain.point;

import ladder.core.DirectionGenerator;

import java.util.*;

import static ladder.domain.point.DirectionValue.*;

public class UnconnectedRandomDirectionGenerator implements DirectionGenerator {
    private static final Random random = new Random();

    @Override
    public Direction next(final Direction current) {
        return NextTemplate.of(current)
                .orElseThrow(NullPointerException::new)
                .next();
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

    private enum NextTemplate {
        LEFT(Direction.of(DirectionValue.LEFT),
                Collections.singletonList(Direction.of(DirectionValue.EMPTY))
        ),
        RIGHT(Direction.of(DirectionValue.RIGHT),
                Collections.singletonList(Direction.of(DirectionValue.LEFT))
        ),
        EMPTY(Direction.of(DirectionValue.EMPTY),
                Arrays.asList(Direction.of(DirectionValue.EMPTY), Direction.of(DirectionValue.LEFT), Direction.of(DirectionValue.RIGHT))
        );

        private static final Random random = new Random();

        private final Direction matchesDirection;
        private final List<Direction> data;

        NextTemplate(final Direction matchesDirection, final List<Direction> data) {
            this.matchesDirection = matchesDirection;
            this.data = data;
        }

        public Direction next() {
            return data.get(
                    random.nextInt(data.size()
                    )
            );
        }

        private static Optional<NextTemplate> of(Direction direction) {
            return Arrays.stream(values())
                    .filter(iNextTemplate ->
                            iNextTemplate.matchesDirection.equals(direction)
                    ).findFirst();
        }
    }
}
