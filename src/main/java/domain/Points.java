package domain;

import java.util.ArrayList;
import java.util.List;

public class Points {

  private List<Point> points;

  public Points() {
    this.points = new ArrayList<>();
  }

  public void add() {
    points.add(Point.generatePoint(points));
  }

  public List<Point> gets() {
    return points;
  }
}
