package ladder.core;

import ladder.domain.point.Direction;

public interface DirectionGenerator {
    Direction next(Direction current);

    Direction first();

    Direction last(Direction current);
}
