package nextstep.ladder.domain;

import java.util.function.IntUnaryOperator;

public enum MoveDirection {
  LEFT((number) -> number - 1),
  RIGHT((number) -> number + 1),
  STRAIGHT((number) -> number);

  private final IntUnaryOperator operator;

  MoveDirection(IntUnaryOperator operator) {
    this.operator = operator;
  }

  public int apply(int number) {
    return operator.applyAsInt(number);
  }
}
