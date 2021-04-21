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

  public int move(final int index) {
    return expression.apply(index);
  }
}
