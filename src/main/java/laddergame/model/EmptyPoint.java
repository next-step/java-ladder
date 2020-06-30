package laddergame.model;

import java.util.Objects;

public class EmptyPoint implements Point {

  private final Position position;

  public EmptyPoint(Position position) {
    this.position = position;
  }

  @Override
  public Position getPosition() {
    return position;
  }

  @Override
  public Position getNextPosition() {
    return position;
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmptyPoint that = (EmptyPoint) o;
    return position.equals(that.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }

  @Override
  public String toString() {
    return "EmptyPoint{" +
        "position=" + position +
        '}';
  }
}
