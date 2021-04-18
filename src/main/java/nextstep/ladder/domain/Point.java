package nextstep.ladder.domain;

import java.util.Objects;

public final class Point {

  private final boolean point;

  private Point(boolean point) {
    this.point = point;
  }

  public static Point head() {
    return new Point(false);
  }

  public static Point body(Point before, boolean canCreate) {
    return new Point(!before.point && canCreate);
  }

  public boolean canDraw() {
    return point;
  }

  public boolean hasLine() {
    return point;
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
