package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Line {

  private final List<Point> points;

  public Line(int countOfPerson) {
    points = new ArrayList<>();
    for (int i = 0; i < countOfPerson; i++) {
      points.add(makePoint());
    }
  }

  public Line(List<Point> points) {
    this.points = points;
  }

  private Point makePoint() {
    Random random = new Random();
    if (points.size() == 0) {
      return new Point(false);
    }

    Point prePoint = points.get(points.size() - 1);
    if (prePoint.isUsed()) {
      return new Point(false);
    }

    return new Point(random.nextBoolean());

  }

  public int size() {
    return points.size();
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Line line = (Line) o;
    return Objects.equals(points, line.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }

  public List<Point> getPoints() {
    return points;
  }

}
