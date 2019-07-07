package ladder.impl;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

  private static final String LAST_POINT_SYMBOL = "|";
  private static final String POINT_JOINING_SYMBOL = "";

  List<Point> points = new ArrayList<>();

  public LadderLine(int countOfPlayer) {
    Point firstPoint = firstPointMake();
    Point BodyLastPoint = makeBodyPoints(countOfPlayer, firstPoint);
    Point last = BodyLastPoint.last(countOfPlayer - 1);
    points.add(last);
  }

  private Point makeBodyPoints(int countOfPlayer, Point firstPoint) {
    Point currentPoint = firstPoint;
    for (int i = 1; i < countOfPlayer - 1; i++) {
      currentPoint = currentPoint.next();
      points.add(currentPoint);
    }
    return currentPoint;
  }

  private Point firstPointMake() {
    Point firstPoint = Point.first();
    points.add(firstPoint);
    return firstPoint;
  }

  private LadderLine(List<Point> points) {
    this.points = points;
  }

  public static LadderLine of(int countOfPlayer) {
    return new LadderLine(countOfPlayer);
  }

  public static LadderLine of(List<Point> points) {
    return new LadderLine(points);
  }

  public int move(int position) {
    return getPoint(position).move().value();
  }

  private Point getPoint(int position) {
    return points.get(position);
  }

  @Override
  public String toString() {
    return points.stream()
        .limit(points.size() - 1)
        .map(Point::toString)
        .collect(joining(POINT_JOINING_SYMBOL))
        .concat(LAST_POINT_SYMBOL);
  }

}
