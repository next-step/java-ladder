package ladder.domain.movestrategy;

import ladder.domain.Direction;
import ladder.domain.Sides;

public class NormalMoveStrategy implements MoveStrategy {
  @Override
  public Direction move(Sides sides) {
    if (sides.right()) {
      return Direction.RIGHT;
    }

    if (sides.left()) {
      return Direction.LEFT;
    }

    return Direction.STRAIGHT;
  }
}
