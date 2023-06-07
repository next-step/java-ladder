package nextstep.laddergame.engine;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.laddergame.engine.strategy.LineStrategy;

public class Row {

  private final List<Point> points;

  public Row(List<Point> points) {
    if (points.size() < 1) {
      throw new IllegalArgumentException("사다리의 넓이(Point 갯수)는 1보다 작을 수 없습니다.");
    }

    if (points.stream().anyMatch(Point::checkTwoWay)) {
      throw new IllegalArgumentException("Line은 겹칠 수 없습니다.");
    }

    this.points = points;
  }

  public static Row createRow(int width, LineStrategy lineStrategy) {
    List<Point> points = initPoints(width);
    return new Row(makeLines(lineStrategy, points));
  }

  private static List<Point> initPoints(int width) {
    return IntStream.range(0, width)
        .mapToObj(i -> new Point())
        .collect(Collectors.toList());
  }

  private static List<Point> makeLines(LineStrategy lineStrategy, List<Point> points) {
    IntStream.range(0, points.size() - 1)
        .filter(i -> lineStrategy.canCreateLine(points.get(i), points.get(i + 1)))
        .forEach(i -> makeLine(points.get(i), points.get(i + 1)));

    return points;
  }

  private static void makeLine(Point leftPont, Point rightPoint) {
    leftPont.createLineWithRightPoint();
    rightPoint.createLineWithLeftPoint();
  }

  public List<Point> getPoints() {
    return Collections.unmodifiableList(points);
  }

  public Point getPoint(int location) {
    return points.get(location);
  }
}
