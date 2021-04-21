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
      return new Point(0, Direction.RIGHT);
    }
    return new Point(0, Direction.NONE);
  }

  public Point next(boolean right) {
    return null;
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
