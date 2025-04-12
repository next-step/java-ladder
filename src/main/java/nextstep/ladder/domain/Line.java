package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
  private static final int SPACE_WIDTH = 5;
  private static final String VERTICAL_SYMBOL = "|";
  private static final String HORIZONTAL_SYMBOL = "-";
  private static final String EMPTY_SYMBOL = " ";

  private final List<Point> points;

  public Line(Players players, LineGenerateStrategy strategy) {
    this.points = createPoints(players, strategy);
  }

  private List<Point> createPoints(Players players, LineGenerateStrategy strategy) {
    List<Point> points = new ArrayList<>();

    for (int i = 0; i < players.size() - 1; i++) {
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
