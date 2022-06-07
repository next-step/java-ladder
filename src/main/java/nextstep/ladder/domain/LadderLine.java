package nextstep.ladder.domain;

import static nextstep.ladder.util.LadderPointGenerator.generateByHalfRate;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

  private static final int ONE_DIFF = 1;
  private static final int SECOND_INDEX = 1;

  private final List<Point> points;

  public LadderLine(List<Point> points) {
    this.points = points;
  }

  public static LadderLine init(int count) {
    List<Point> points = new ArrayList<>();
    Point point = initFirst(points);
    for (int i = SECOND_INDEX; i < count - ONE_DIFF; i++) {
      point = point.next();
      points.add(point);
    }
    initLast(points, point);
    return new LadderLine(points);
  }

  private static Point initFirst(List<Point> points) {
    Point first = Point.first(generateByHalfRate());
    points.add(first);
    return first;
  }

  private static Point initLast(List<Point> points, Point point) {
    Point last = point.last();
    points.add(last);
    return last;
  }

  public int size() {
    return points.size();
  }
}
