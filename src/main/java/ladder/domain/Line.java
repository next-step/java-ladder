package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import ladder.domain.generator.Generator;

public class Line {

  private final List<Point> points;

  public Line(Generator generator) {
    this(generator.makePoints());
  }

  public Line(List<Point> points) {
    this.points = points;
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

  public boolean point(int idx) {
    return points.get(idx).isUsed();
  }

  public int size() {
    return points.size();
  }
}
