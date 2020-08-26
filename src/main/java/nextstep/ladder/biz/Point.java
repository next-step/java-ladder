package nextstep.ladder.biz;

import java.util.Objects;

public class Point {

  private boolean point;

  Point(boolean point) {
    this.point = point;
  }

  public boolean hasPoint() {
    return point;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point1 = (Point) o;
    return point == point1.point;
  }

  @Override
  public int hashCode() {
    return Objects.hash(point);
  }

  @Override
  public String toString() {
    return "Point{" +
        "point=" + point +
        '}';
  }

  public static Point of(boolean hasPoint) {
    return new Point(hasPoint);
  }

}
