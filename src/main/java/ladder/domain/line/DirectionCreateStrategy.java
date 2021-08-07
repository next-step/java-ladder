package ladder.domain.line;

import ladder.domain.point.Direction;

public interface DirectionCreateStrategy {
    Direction next(Direction current);

    Direction first();

    Direction last(Direction current);
}
