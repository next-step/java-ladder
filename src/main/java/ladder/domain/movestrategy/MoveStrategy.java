package ladder.domain.movestrategy;

import ladder.domain.Direction;
import ladder.domain.Sides;

@FunctionalInterface
public interface MoveStrategy {
  Direction move(Sides sides);
}
