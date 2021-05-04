package ladder.domain;

import ladder.constants.Move;

import java.util.Objects;

public class Direction {
  private final Move value;

  private Direction(Move value) {
    this.value = value;
  }

  public static Direction create(boolean right, boolean left) {
    return new Direction(Move.valueOf(right, left));
  }

  public Move getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Direction direction = (Direction) o;
    return value == direction.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Direction{" +
            "value=" + value +
            '}';
  }
}
