package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Line {

  private final List<Point> points;

  public Line(final LineCreationStrategy lineCreationStrategy, final int personCount) {
    this.points = createPoints(lineCreationStrategy, personCount);
  }

  private List<Point> createPoints(LineCreationStrategy lineCreationStrategy, int personCount) {
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < personCount; i++) {
      points.add(new Point(lineCreationStrategy.canCreate()));
    }
    return points;
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
