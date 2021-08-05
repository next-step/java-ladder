package ladder.core;

import ladder.domain.direction.Direction;

public interface DirectionGenerator {
    Direction next(Direction current);

    Direction first();

    Direction last(Direction current);
}
