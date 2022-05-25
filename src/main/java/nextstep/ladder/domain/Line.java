package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line {

  private final List<Boolean> points;

  private Line(List<Boolean> points) {
    this.points = points;
  }

  public static Line from(int countOfPerson, PointStrategy strategy) {
    List<Boolean> points = new ArrayList<>();
    points.add(strategy.linkable());
    for (int i = 1; i < countOfPerson - 1; i++) {
      points.add(point(points.get(i - 1), strategy.linkable()));
    }
    return from(points);
  }

  public static Line from(List<Boolean> points) {
    return new Line(points);
  }

  private static Boolean point(boolean prev, boolean current) {
    if (prev == current) {
      return false;
    }
    return current;
  }

  public List<Boolean> points() {
    return Collections.unmodifiableList(points);
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
}
