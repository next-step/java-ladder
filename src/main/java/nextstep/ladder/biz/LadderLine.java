package nextstep.ladder.biz;

import java.util.ArrayList;
import java.util.List;

import static nextstep.ladder.biz.LineGenerator.nextBoolean;

public class LadderLine {

  private List<PointDirection> points;

  public LadderLine(List<PointDirection> points) {
    this.points = points;
  }

  public int move(int position) {
    return points.get(position).move();
  }

  public static LadderLine init(int sizeOfPerson) {
    List<PointDirection> points = new ArrayList<>();
    PointDirection point = initFirst(points);
    point = initBody(sizeOfPerson, points, point);
    initLast(points, point);
    return new LadderLine(points);
  }

  private static PointDirection initFirst(List<PointDirection> points) {
    PointDirection first = PointDirection.first(nextBoolean());
    points.add(first);
    return first;
  }

  private static PointDirection initBody(int sizeOfPerson, List<PointDirection> points, PointDirection point) {
    for (int i = 1; i < sizeOfPerson - 1; i++) {
      point = point.next();
      points.add(point);
    }
    return point;
  }

  private static void initLast(List<PointDirection> points, PointDirection previousPoint) {
    points.add(previousPoint.last());
  }

  @Override
  public String toString() {
    return "LadderLine{" +
            "points=" + points +
            '}';
  }
}
