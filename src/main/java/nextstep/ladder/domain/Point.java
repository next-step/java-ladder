package nextstep.ladder.domain;

import java.util.Objects;

public final class Point {

  public static final String LINE = "-----|";
  public static final String NOT_LINE = "     |";

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

  public String draw() {
    return point ? LINE : NOT_LINE;
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
