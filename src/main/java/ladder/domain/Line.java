package ladder.domain;

import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Line {

  private List<Point> points = new ArrayList<>();

  private Line(Players players) {
    Point point = Point.of(RandomGenerator.nextBoolean());

    for (int i = 0; i < players.size() - 1; i++) {
      points.add(point);
      point = randomBar(point);
    }
  }

  public static Line of(Players players) {
    return new Line(players);
  }

  private Point randomBar(Point point) {
    if (point.isCurrent()) {
      return Point.of(false);
    }
    return Point.of(RandomGenerator.nextBoolean());
  }

  public int size() {
    return points.size();
  }

  public List<Boolean> getLine() {
    return points.stream()
        .map(Point::isCurrent)
        .collect(toList());
  }
}
