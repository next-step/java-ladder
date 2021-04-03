package ladder.domain.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ladder.domain.Point;

public class PointsGenerator implements Generator {

  private static final Random random = new Random();
  private final int countOfPoint;

  public PointsGenerator(int countOfPoint) {
    this.countOfPoint = countOfPoint;
  }

  @Override
  public List<Point> makePoints() {
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < countOfPoint; i++) {
      Point p = makePoint(points);
      points.add(p);
    }

    return points;
  }

  private Point makePoint(List<Point> points) {
    if (points.isEmpty()) {
      return new Point(false);
    }

    Point prePoint = points.get(points.size() - 1);
    if (prePoint.isUsed()) {
      return new Point(false);

    }
    return new Point(random.nextBoolean());
  }


}
