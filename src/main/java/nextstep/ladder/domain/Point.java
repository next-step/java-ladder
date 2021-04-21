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
    if (headRight) {
      return createRightDirectionPoint(0);
    }
    return createNoneDirectionPoint(0);
  }

  private static Point createRightDirectionPoint(int index) {
    return new Point(index, Direction.RIGHT);
  }

  private static Point createNoneDirectionPoint(int index) {
    return new Point(index, Direction.NONE);
  }

  private static Point createLeftDirectionPoint(int index) {
    return new Point(index, Direction.LEFT);
  }

  public Point next(boolean right) {
    final int nextIndex = getNextIndex();

    if (direction == Direction.RIGHT) {
      return createLeftDirectionPoint(nextIndex);
    }
    if (right) {
      return createRightDirectionPoint(nextIndex);
    }
    return createNoneDirectionPoint(nextIndex);
  }

  public Point tail() {
    final int nextIndex = getNextIndex();

    if (direction == Direction.RIGHT) {
      return createLeftDirectionPoint(nextIndex);
    }
    return createNoneDirectionPoint(nextIndex);
  }

  private int getNextIndex() {
    return this.index + 1;
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
