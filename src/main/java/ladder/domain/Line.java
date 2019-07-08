package ladder.domain;

import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Line {

  private List<Point> points = new ArrayList<>();

  private Line(Players players) {
    Point point = Point.first(RandomGenerator.nextBoolean());
    points.add(point);

    for (int i = 0; i < players.size() - 1; i++) {
      point = randomBar(point);
      points.add(point);
    }
  }

  private Line(int numOfPlayers) {
    Point point = Point.first(RandomGenerator.nextBoolean());
    points.add(point);

    for (int i = 0; i < numOfPlayers - 2; i++) {
      point = point.next(RandomGenerator.nextBoolean());
      points.add(point);
    }

    points.add(point.last());
  }

  private Line(List<Point> points) {
    this.points = points;
  }

  public static Line of(Players players) {
    return new Line(players);
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

  public int size() {
    return points.size();
  }

  public List<Boolean> getLine() {
    return points.stream()
        .map(Point::isCurrent)
        .collect(toList());
  }
}
