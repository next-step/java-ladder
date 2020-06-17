package laddergame.model;

import java.util.Objects;

public class Position {

  private NaturalNumber value;

  public Position(NaturalNumber value) {
    this.value = value;
  }

   public void movePositions(boolean canMoveLeft, boolean canMoveRight) {
    if (canMoveLeft) {
      moveLeft();
      return;
    }
    if (canMoveRight) {
      moveRight();
    }
  }

  public int getValue() {
    return value.getValue();
  }

  public void moveLeft() {
    this.value = value.minusOne();
  }

  public void moveRight() {
    this.value = value.plusOne();
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

  @Override
  public String toString() {
    return "Position{" +
        "value=" + value +
        '}';
  }
}
