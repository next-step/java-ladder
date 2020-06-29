package laddergame.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

  private final List<Point> points;

  public Line(List<Point> points) {
    this.points = points;
  }

  public static Line createByCountOfPerson(int countOfPerson) {
    return new Line(
        Stream.iterate(BasicPoint.create(0), basicPoint -> basicPoint.createNext())
            .limit(countOfPerson)
            .collect(Collectors.toList()));
  }

  public int getNextPositionAt(int index) {
    return points.get(index).getNextPosition();
  }

  public List<Point> getPoints() {
    return Collections.unmodifiableList(points);
  }

  @Override
  public String toString() {
    return "Line{" +
        "basicPoints=" + points +
        '}';
  }
}
