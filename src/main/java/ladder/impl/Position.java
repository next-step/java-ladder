package ladder.impl;

import java.util.Objects;

public class Position {

  private static final int BASIC_MOVE_DISTANCE = 1;
  private static final int MINIMUM_POSITION_VALUE = 0;
  int position;

  public Position(int position) {
    if(position < MINIMUM_POSITION_VALUE ) {
      throw new IllegalArgumentException("위치 값은 0보다 작을 수 없습니다.");
    }
    this.position = position;
  }

  public Position increment() {
    return new Position(position + BASIC_MOVE_DISTANCE);
  }

  public Position decrease() {
    return new Position(position - BASIC_MOVE_DISTANCE);
  }

  public int value() {
    return position;
  }

  @Override
  public String toString() {
    return "Position{" +
        "position=" + position +
        '}';
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
    return position == position1.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }

}
