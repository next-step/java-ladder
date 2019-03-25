package domain;

import java.util.List;
import java.util.Random;

public class Point {

  private static final Point truePoint = new Point(true);
  private static final Point falsePoint = new Point(false);

  private boolean point;

  private Point(boolean point) {
    this.point = point;
  }

  public static Point of(boolean isPoint) {
    return isPoint ? truePoint : falsePoint;
  }

  public static Point generatePoint(List<Point> points) {

    if (points.size() == 0) {
      return falsePoint;
    }

    if (points.get(points.size() - 1).is()) {
      return falsePoint;
    }

    return Point.of(new Random().nextBoolean());
  }

  public boolean is() {
    return point;
  }
}
