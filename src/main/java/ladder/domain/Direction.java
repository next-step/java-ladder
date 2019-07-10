package ladder.domain;

public enum Direction {
  RIGHT(false, true),
  LEFT(true, false),
  PASS(false, false);

  private final static int MOVE_INDEX = 1;
  private final boolean left;
  private final boolean right;

  Direction(boolean left, boolean right) {
    if (left && right) {
      throw new IllegalArgumentException();
    }

    this.left = left;
    this.right = right;
  }

  public static Direction first(boolean right) {
    if (right) {
      return Direction.RIGHT;
    }
    return Direction.PASS;
  }

  public Direction next(boolean right) {
    if (!this.right && right) {
      return Direction.RIGHT;
    }
    if (!this.right) {
      return Direction.PASS;
    }

    return Direction.LEFT;
  }

  public Direction last() {
    if (this.right) {
      return Direction.LEFT;
    }
    return Direction.PASS;
  }

  int move(int index) {
    if (this.left) {
      return index - MOVE_INDEX;
    }
    if (this.right) {
      return index + MOVE_INDEX;
    }
    return index;
  }

  boolean isRight() {
    return this.right;
  }

}
