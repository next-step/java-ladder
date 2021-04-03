package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
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

  public Stream<Point> points() {
    return points.stream();
  }

  public Position travel(Position position) {

    if (position.isRightMove(points)) {
      return position.rightMove();
    }

    if (position.isLeftMove(points)) {
      return position.leftMove();
    }

    return position;
  }
}
