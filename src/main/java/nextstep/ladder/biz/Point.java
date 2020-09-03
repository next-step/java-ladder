package nextstep.ladder.biz;

import java.util.Objects;

public class Point {

  private final boolean point;
  private int position;

  Point(boolean point, int position) {
    this.point = point;
    this.position = position;
  }

  public boolean hasPoint() {
    return point;
  }

  public boolean isLeftPosition(int location) {
    return position == location -1;
  }

  public boolean isHerePosition(int location) {
    return position == location;
  }

  public static Point of(boolean hasPoint) {
    return new Point(hasPoint, 0);
  }

  public static Point of(boolean hasPoint, int position) {
    return new Point(hasPoint, position);
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
