package ladder.domain;

import ladder.constants.Move;
import ladder.exception.InvalidDirectionException;

import java.util.Objects;

public class Direction {
  private final Move value;

  private Direction(Move value) {
    this.value = value;
  }

  public static Direction create(boolean right, boolean left) {
    checkValidDirection(right, left);

    if (right) {
      return new Direction(Move.RIGHT);
    }

    if (left) {
      return new Direction(Move.LEFT);
    }

    return new Direction(Move.STAY);
  }

  private static void checkValidDirection(boolean right, boolean left) {
    if (right && left) {
      throw new InvalidDirectionException();
    }
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
