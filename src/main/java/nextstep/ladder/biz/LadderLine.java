package nextstep.ladder.biz;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.biz.RandomGenerator.nextBoolean;

public class LadderLine {

  private List<Point> points;

  public LadderLine(List<Point> points) {
    this.points = points;
  }

  // Add ME
  public List<Point> getPoints() {
    return points;
  }

  public int move(int position) {
    return points.get(position).move();
  }

  public static LadderLine init(int sizeOfPerson) {
    List<Point> points = new ArrayList<>();
    Point point = initFirst(points);
    point = initBody(sizeOfPerson, points, point);
    initLast(points, point);
    return new LadderLine(points);
  }

  private static Point initFirst(List<Point> points) {
    Point first = Point.first(nextBoolean());
    points.add(first);
    return first;
  }

  private static Point initBody(int sizeOfPerson, List<Point> points, Point point) {
    for (int i = 1; i < sizeOfPerson - 1; i++) {
      point = point.next();
      points.add(point);
    }
    return point;
  }

  private static void initLast(List<Point> points, Point previousPoint) {
    points.add(previousPoint.last());
  }

  @Override
  public String toString() {
    return "LadderLine{" +
            "points=" + points +
            '}';
  }
}
