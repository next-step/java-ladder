package ladder.domain.point;

import ladder.core.DirectionCreateStrategy;

import java.util.*;

import static ladder.domain.point.Direction.*;

public class UnconnectedRandomDirectionCreateStrategy implements DirectionCreateStrategy {
    private static final Random random = new Random();

    @Override
    public Direction next(final Direction current) {
        return NextTemplate.of(current)
                .orElseThrow(NullPointerException::new)
                .next();
    }

    @Override
    public Direction first() {
        return random.nextBoolean() ? RIGHT : EMPTY;
    }

    @Override
    public Direction last(Direction current) {
        return current.isRight() ? LEFT : EMPTY;
    }

    private enum NextTemplate {
        LEFT(Direction.LEFT,
                Collections.singletonList(Direction.EMPTY)
        ),
        RIGHT(Direction.RIGHT,
                Collections.singletonList(Direction.LEFT)
        ),
        EMPTY(Direction.EMPTY,
                Arrays.asList(Direction.EMPTY, Direction.LEFT, Direction.RIGHT)
        );

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
