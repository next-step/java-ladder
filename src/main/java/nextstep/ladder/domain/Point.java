package nextstep.ladder.domain;

import java.util.Objects;

public final class Point {

  private final int index;
  private final Direction direction;

  private Point(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
  }

  public static Point head(boolean headRight) {
    return Point.of(0, Direction.valueOf(headRight));
  }

  private static Point of(int index, Direction direction) {
    return new Point(index, direction);
  }

  public Point next(boolean right) {
    return nextPoint(right);
  }

  public Point tail() {
    return nextPoint(false);
  }

  private Point nextPoint(boolean isRight) {
    return Point.of(nextIndex(), nextDirection(isRight));
  }

  private int nextIndex() {
    return this.index + 1;
  }

  private Direction nextDirection(boolean isRight) {
    if (direction == Direction.RIGHT) {
      return Direction.LEFT;
    }

    return Direction.valueOf(isRight);
  }

  public boolean canDraw() {
    return direction == Direction.LEFT;
  }

  public int move() {
    return direction.move(index);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return index == point.index && direction == point.direction;
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, direction);
  }
}
