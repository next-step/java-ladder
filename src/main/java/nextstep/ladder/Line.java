package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
  private static final int SPACE_WIDTH = 5;
  private static final String VERTICAL_SYMBOL = "|";
  private static final String HORIZONTAL_SYMBOL = "-";
  private static final String EMPTY_SYMBOL = " ";

  private final List<Point> points;

  public Line(int countOfPerson, DirectionStrategy strategy) {
    this.points = createPoints(countOfPerson, strategy);
  }

  private List<Point> createPoints(int countOfPerson, DirectionStrategy strategy) {
    List<Point> points = new ArrayList<>();

    for (int i = 0; i < countOfPerson - 1; i++) {
      if (i > 0 && points.get(i - 1).hasLine()) {
        points.add(new Point(false));
      } else {
        points.add(new Point(strategy.generate()));
      }
    }

    return points;
  }

  public String toConsoleOutput() {
    StringBuilder sb = new StringBuilder(" ".repeat(SPACE_WIDTH));
    for (Point point : points) {
      if (point.hasLine()) {
        sb.append(VERTICAL_SYMBOL).append(HORIZONTAL_SYMBOL.repeat(SPACE_WIDTH - 1));
      } else {
        sb.append(VERTICAL_SYMBOL).append(EMPTY_SYMBOL.repeat(SPACE_WIDTH - 1));
      }
    }
    sb.append(VERTICAL_SYMBOL);
    return sb.toString();
  }
}
