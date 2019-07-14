package ladder.domain;

import ladder.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static ladder.domain.Point.START_INDEX;

public class Line {

  private static final int LAST_INDEX_LINE = 2;
  private List<Point> points;


  private Line(List<Point> points) {
    this.points = points;
  }

  public static Line of(List<Point> points) {
    return new Line(points);
  }

  public static Line of(int numOfPlayers) {
    List<Point> points = new ArrayList<>();
    Point point = initFirst(points);
    point = initBody(numOfPlayers, points, point);
    initLast(points, point.last());
    return new Line(points);
  }

  private static void initLast(List<Point> points, Point last) {
    points.add(last);
  }

  private static Point initBody(int numOfPlayers, List<Point> points, Point point) {
    for (int i = START_INDEX; i < numOfPlayers - LAST_INDEX_LINE; i++) {
      point = point.next(RandomGenerator.nextBoolean());
      points.add(point);
    }
    return point;
  }

  private static Point initFirst(List<Point> points) {
    Point point = Point.first(RandomGenerator.nextBoolean());
    points.add(point);
    return point;
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
