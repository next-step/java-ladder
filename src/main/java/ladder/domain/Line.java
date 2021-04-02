package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import ladder.domain.generator.Generator;
import ladder.domain.generator.PointsGenerator;

public class Line {

  private final List<Point> points;

  public Line(int countOfPerson) {
    this.points = makePoints(new PointsGenerator(countOfPerson));
  }

  public Line(List<Point> points) {
    this.points = points;
  }

  public List<Point> makePoints(Generator generator) {
    return generator.makePoints();
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
