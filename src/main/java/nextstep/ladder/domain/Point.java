package nextstep.ladder.domain;

import java.util.Objects;

public final class Point {

  private boolean point;
  private int index;
  private Direction direction;

  private Point(boolean point) {
    this.point = point;
  }

  private Point(int index, Direction direction) {
    this.index = index;
    this.direction = direction;
  }

  public static Point head() {
    return new Point(false);
  }

  public static Point body(Point before, boolean canCreate) {
    return new Point(!before.point && canCreate);
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
    final int nextIndex = this.index + 1;

    if (direction == Direction.RIGHT) {
      return createLeftDirectionPoint(nextIndex);
    }
    if (right) {
      return createRightDirectionPoint(nextIndex);
    }
    return createNoneDirectionPoint(nextIndex);
  }

  public Point tail() {
    return null;
  }

  public boolean canDraw() {
    return point;
  }

  public boolean hasLine() {
    return point;
  }

  public int move() {
    return direction.move(index);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Point)) {
      return false;
    }
    Point point1 = (Point) o;
    return point == point1.point;
  }

  @Override
  public int hashCode() {
    return Objects.hash(point);
  }
}
