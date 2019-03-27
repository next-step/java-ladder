package domain;

import java.util.List;
import java.util.Random;

public class Point {

  private boolean point;
  private Point(boolean point) {
    this.point = point;
  }

  public static Point of(boolean isPoint) {
    return new Point(isPoint);
  }

  public static Point generatePoint(List<Point> points) {

    if (points.size() == 0) {
      return new Point(false);
    }

    if (points.get(points.size() - 1).is()) {
      return new Point(false);
    }

    return Point.of(new Random().nextBoolean());
  }

  public boolean is() {
    return point;
  }
}
