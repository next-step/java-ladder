package nextstep.laddergame;

import java.util.ArrayList;
import java.util.List;
import nextstep.laddergame.domain.Line;
import nextstep.laddergame.domain.Point;

public class ProtoLine {
  private final List<Point> points;

  private ProtoLine(List<Point> points) {
    this.points = points;
  }

  public ProtoLine() {
    this(new ArrayList<>());
  }

  protected void add(Boolean next) {
    if(points.size() == 0) {
      points.add(Point.first(next));
      return;
    }
    Point point = lastOfPoints();
    if(drawLeft()) {
      points.add(point.next(false));
      return;
    }
    points.add(point.next(next));
  }

  private Point lastOfPoints() {
    return points.get(points.size() - 1);
  }

  protected ProtoLine merge(ProtoLine other) {
    List<Point> result = new ArrayList<>(points);
    result.addAll(other.points);
    return new ProtoLine(result);
  }

  protected Line toLine() {
    return new Line(points);
  }

  private Boolean drawLeft() {
    return !points.isEmpty() && lastOfPoints().hasRight();
  }

}
