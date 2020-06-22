package laddergame.model;

import java.util.Objects;

public class Position {

  private NaturalNumber value;

  public Position(NaturalNumber value) {
    this.value = value;
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

  public void movePositionBy(Line line) {
    /**
     * point로 line 사이를 이어준다.
     * cur 기준 point 위치는 다음과 같다.
     * left == line[cur]
     * right == right[cur+1]
     */
    if (line.hasRungAt(getValue())) {
      moveLeft();
      return;
    }

    if (line.hasRungAt(getValue() + 1)) {
      moveRight();
    }
  }
}
