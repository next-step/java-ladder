package nextstep.ladder.biz;

import java.util.Objects;

public class Point {

  private final boolean point;
  private int position;

  Point(boolean point) {
    this.point = point;
  }

  Point(boolean point, int position) {
    this.point = point;
    this.position = position;
  }

  public boolean hasPoint() {
    return point;
  }

  public static Point of(boolean hasPoint) {
    return new Point(hasPoint);
  }

  public static Point of(boolean hasPoint, int position) {
    return new Point(hasPoint, position);
  }

  public int decide(int index) {
    int left = index - 1;

    if (position == index) {
      return point ? index + 1 : index;
    }

    if (position == left) {
      return point ? index -1 : index;
    }

    return index;
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
    return point == point1.point &&
        position == point1.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(point, position);
  }

  @Override
  public String toString() {
    return "Point{" +
        "point=" + point +
        ", position=" + position +
        '}';
  }
}
