package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.model.LadderGenerationRule;
import nextstep.ladder.domain.model.Point;

public class LadderLine {
  private final List<Point> points;

  public LadderLine(List<Point> points) {
    this.points = points;
  }

  public int move(int position) {
    return points.get(position).move();
  }

  public static LadderLine init(int sizeOfPerson, LadderGenerationRule rule) {
    List<Point> points = new ArrayList<>();
    initFirst(points, rule);
    Point point = initBody(sizeOfPerson, points, rule);
    initLast(points, point);
    return new LadderLine(points);
  }

  private static Point initBody(int sizeOfPerson, List<Point> points, LadderGenerationRule rule) {
    Point point = points.get(0);
    for (int i = 1; i < sizeOfPerson - 1; i++) {
      point = point.next(rule);
      points.add(point);
    }
    return point;
  }

  private static void initLast(List<Point> points, Point point) {
    point = point.last();
    points.add(point);
  }

  private static void initFirst(List<Point> points, LadderGenerationRule rule) {
    Point point = Point.first(rule.generate()); // point generater
    points.add(point);
  }

  @Override
  public String toString() {
    return "LadderLine{" +
        "points=" + points +
        '}';
  }
}