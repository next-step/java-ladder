package ladder.domain;

import java.util.Objects;

public class Position {
  public static final int RIGHT = 1;
  public static final int LEFT = -1;

  private final int value;

  public Position(int value) {
    this.value = value;
  }

  public Position right() {
    return new Position(move(RIGHT));
  }

  public Position left() {
    return new Position(move(LEFT));
  }

  private int move(int status) {
    return value + status;
  }

  public int getValue() {
    return value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position = (Position) o;
    return value == position.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Position{" +
            "value=" + value +
            '}';
  }
}
