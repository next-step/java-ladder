package ladder.domain;

import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static ladder.domain.Point.START_INDEX;

public class Line {

  private static final int LAST_INDEX_LINE = 2;
  private List<Point> points = new ArrayList<>();

  private Line(int numOfPlayers) {
    Point point = Point.first(RandomGenerator.nextBoolean());
    points.add(point);

    for (int i = START_INDEX; i < numOfPlayers - LAST_INDEX_LINE; i++) {
      point = randomBar(point);
      points.add(point);
    }

    points.add(point.last());
  }

  private Line(List<Point> points) {
    this.points = points;
  }

  public static Line of(List<Point> points) {
    return new Line(points);
  }

  public static Line of(int numOfPlayers) {
    return new Line(numOfPlayers);
  }

  int move(int i) {
    return points.get(i).move();
  }

  private Point randomBar(Point point) {
    return point.next(RandomGenerator.nextBoolean());
  }

  public List<Boolean> getLine() {
    return points.stream()
        .map(Point::isCurrent)
        .collect(toList());
  }
}
