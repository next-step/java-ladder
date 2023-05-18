package nextstep.laddergame.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.laddergame.domain.Point;
import nextstep.laddergame.domain.Row;
import nextstep.laddergame.domain.strategy.LineStrategy;

public class RowFactory {

  private RowFactory() {
  }

  static public Row createRow(int width, LineStrategy lineStrategy) {
    List<Point> points = initPoints(width);
    return new Row(makeLines(lineStrategy, points));
  }

  static private List<Point> initPoints(int width) {
    return IntStream.range(0, width)
        .mapToObj(i -> new Point())
        .collect(Collectors.toList());
  }

  static private List<Point> makeLines(LineStrategy lineStrategy, List<Point> points) {
    IntStream.range(0, points.size() - 1)
        .filter(i -> lineStrategy.isCreateLine(points.get(i), points.get(i + 1)))
        .forEach(i -> makeLine(points.get(i), points.get(i + 1)));

    return points;
  }

  static private void makeLine(Point leftPont, Point rightPoint) {
    leftPont.createLineWithRightPoint();
    rightPoint.createLineWithLeftPoint();
  }
}
