package ladder.domain.ladder.line.point;

public enum LadderPointDirection {
  RIGHT,
  LEFT,
  NONE;

  public LadderPointDirection getOppositeDirection () {
    if (this == RIGHT) {
      return LEFT;
    }

    if (this == LEFT) {
      return RIGHT;
    }

    return null;
  }
}
