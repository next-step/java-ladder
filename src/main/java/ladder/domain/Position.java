package ladder.domain;

import java.util.Objects;

public class Position {

  private final int value;

  public Position(int value) {
    this.value = value;
  }

  public Position rightMove() {
    return new Position(value + 1);
  }

  public Position leftMove() {
    return new Position(value - 1);
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position1 = (Position) o;
    return value == position1.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Position{" +
        "position=" + value +
        '}';
  }
}
