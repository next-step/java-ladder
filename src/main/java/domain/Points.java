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

  public void add(Point point) {
    points.add(point);
  }

  public List<Point> gets() {
    return points;
  }

  public int move(int position) {

    if (position >= points.size()) {
      throw new IllegalArgumentException();
    }

    if (points.get(position).is()) {
      return position - 1;
    }

    if ((points.size() - 1) == position) {
      return position;
    }

    if (points.get(position + 1).is()) {
      return position + 1;
    }

    return position;
  }
}
