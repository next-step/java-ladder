package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.ladder.DirectionStrategy;

public class LadderLine {

  private List<Point> points;

  private LadderLine(List<Point> points) {
    this.points = points;
  }

  public static LadderLine generate(int sizeOfPerson, DirectionStrategy directionStrategy) {
    List<Point> points = new ArrayList<>();
    Point point = addFirstPoint(points, directionStrategy);
    point = addPoint(sizeOfPerson, points, point, directionStrategy);
    addLastPoint(points, point);
    return new LadderLine(points);
  }

  private static Point addFirstPoint(List<Point> points, DirectionStrategy directionStrategy) {
    Point point = Point.first(directionStrategy);
    points.add(point);
    return point;
  }

  private static Point addPoint(int sizeOfPerson, List<Point> points, Point point, DirectionStrategy directionStrategy) {
    for (int i = 1; i < sizeOfPerson - 1; i++) {
      point = point.next(directionStrategy);
      points.add(point);
    }
    return point;
  }

  private static void addLastPoint(List<Point> points, Point point) {
    points.add(point.last());
  }

  public int move(int index) {
    return points.get(index).move();
  }

  public int size() {
    return points.size();
  }

  public List<Point> getPoints() {
    return points;
  }

  @Override
  public String toString() {
    List<String> pointsString = points.stream().map(Point::isLeft)
        .map(left -> left ? "-----|" : "     |")
        .collect(Collectors.toList());
    return String.join("", pointsString);
  }
}
