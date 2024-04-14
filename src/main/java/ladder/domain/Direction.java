package ladder.domain;

import java.util.function.UnaryOperator;

public enum Direction {
  LEFT(c -> c.move(-1, 1)),
  RIGHT(c -> c.move(1, 1)),
  STRAIGHT(c -> c.move(0, 1));

  public final UnaryOperator<Coordinates> move;

  public Coordinates move(final Coordinates coordinates) {
    return this.move.apply(coordinates);
  }

  Direction(UnaryOperator<Coordinates> move) {
    this.move = move;
  }
}
