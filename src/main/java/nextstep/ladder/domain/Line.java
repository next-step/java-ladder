package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public final class Line {

  private final List<Point> points;

  public Line(final PersonCount personCount, final LineCreationStrategy lineCreationStrategy) {
    this(personCount, lineCreationStrategy.create());
  }

  public Line(final PersonCount personCount, final List<Point> points) {
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
