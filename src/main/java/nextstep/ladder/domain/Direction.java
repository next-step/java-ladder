package nextstep.ladder.domain;

import java.util.function.UnaryOperator;

public enum Direction {

  NONE(index -> index),
  LEFT(index -> index - 1),
  RIGHT(index -> index + 1);

  private final UnaryOperator<Integer> expression;

  Direction(UnaryOperator<Integer> expression) {
    this.expression = expression;
  }

  public static Direction valueOf(boolean isRight) {
    if (isRight) {
      return Direction.RIGHT;
    }
    return Direction.NONE;
  }

  public int move(final int index) {
    return expression.apply(index);
  }
}
