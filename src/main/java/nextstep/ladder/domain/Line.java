package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Line {

  private final List<Point> points;

  public Line(final int countOfPerson) {
    final List<Point> points = new ArrayList<>(countOfPerson);
    for (int i = 0; i < countOfPerson; i++) {
      points.add(new Point(false));
    }
    this.points = points;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Line)) {
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
