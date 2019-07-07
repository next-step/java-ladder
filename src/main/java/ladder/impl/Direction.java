package ladder.impl;

import java.util.Random;

public enum Direction {

  STRAIGHT(Boolean.FALSE, Boolean.FALSE),
  LEFT(Boolean.TRUE, Boolean.FALSE),
  RIGHT(Boolean.FALSE, Boolean.TRUE);

  private static final int RANDOM_BOUND = 2;
  private static final int RIGHT_DIRECTION_CONDITION = 1;

  private static final String HAS_BAR_SYMBOL = "|-----";
  private static final String NO_BAR_SYMBOL = "|     ";

  private static Random random = new Random();

  private Boolean left;
  private Boolean right;

  Direction(Boolean left, Boolean right) {
    this.left = left;
    this.right = right;
  }

  public static Direction first() {
    return randomGenerate();
  }

  private static Direction randomGenerate() {
    if (random.nextInt(RANDOM_BOUND) >= RIGHT_DIRECTION_CONDITION) {
      return Direction.RIGHT;
    }
    return Direction.STRAIGHT;
  }

  public Direction last() {
    if (this == RIGHT) {
      return Direction.LEFT;
    }
    return Direction.STRAIGHT;
  }

  public Position move(Position position) {
    if (this == RIGHT) {
      return position.increment();
    }
    if (this == LEFT) {
      return position.decrease();
    }
    return position;
  }

  public Direction next() {
    if (this == RIGHT) {
      return Direction.LEFT;
    }
    return randomGenerate();
  }

  @Override
  public String toString() {
    if (this == RIGHT) {
      return HAS_BAR_SYMBOL;
    }
    return NO_BAR_SYMBOL;
  }
}
