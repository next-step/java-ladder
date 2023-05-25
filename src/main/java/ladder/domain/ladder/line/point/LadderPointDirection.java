package ladder.domain.ladder.line.point;

import java.util.function.Predicate;
import ladder.domain.player.PlayerPosition;

public enum LadderPointDirection {
  RIGHT(PlayerPosition::goRight),
  LEFT(PlayerPosition::goLeft),
  NONE(PlayerPosition::goDown)
  ;

  private final Predicate<PlayerPosition> isMovedPredicator;

  LadderPointDirection(Predicate<PlayerPosition> isMovedPredicator) {
    this.isMovedPredicator = isMovedPredicator;
  }

  public LadderPointDirection getOppositeDirection () {
    if (this == RIGHT) {
      return LEFT;
    }

    if (this == LEFT) {
      return RIGHT;
    }

    return null;
  }

  public boolean move(PlayerPosition playerPosition) {
    return isMovedPredicator.test(playerPosition);
  }
}
