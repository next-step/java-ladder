package ladder.domain;

import ladder.constants.Move;

import java.util.Objects;

public class Direction {
  private final Move move;

  public Direction(Move move) {
    this.move = move;
  }

  public static Direction create(boolean right, boolean left) {
    return new Direction(Move.valueOf(right, left));
  }

  public int forward(int position) {
    return move.forward(position);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Direction direction = (Direction) o;
    return move == direction.move;
  }

  @Override
  public int hashCode() {
    return Objects.hash(move);
  }

  @Override
  public String toString() {
    return "Direction{" +
            "value=" + move +
            '}';
  }
}
