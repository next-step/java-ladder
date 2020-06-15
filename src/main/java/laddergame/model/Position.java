package laddergame.model;

import java.util.Objects;

public class Position {

  private final NaturalNumber value;

  public Position(NaturalNumber value) {
    this.value = value;
  }

  public void movePositions(Position position, Line line) {
    if (line.leftPointHasRung(position)) {
      position.moveLeft();
      return;
    }
    if (line.rightPointHasRung(position)) {
      position.moveRight();
    }
  }

  public int getValue() {
    return value.getValue();
  }

  public void moveLeft() {
    value.minusOne();
  }

  public void moveRight() {
    value.plusOne();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return value.equals(position.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
