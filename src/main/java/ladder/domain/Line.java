package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

  private final List<Point> points;

  private Line(List<Point> points) {
    this.points = points;
  }

  public int move(int position) {
    return points.get(position).move();
  }

  public static Line init(int countOfPerson, ConnectStrategy connectStrategy) {
    List<Point> points = new ArrayList<>();
    IntStream.range(0, countOfPerson - 1)
        .forEach(i -> points.add(connect(i, points, connectStrategy)));
    connectLast(points, points.get(countOfPerson - 2));
    return new Line(points);
  }

  private static Point connect(int index, List<Point> points, ConnectStrategy connectStrategy) {
    if (points.isEmpty()) {
      return Point.first(connectStrategy.connect());
    }
    return points.get(index - 1).next(connectStrategy);
  }

  private static void connectLast(List<Point> points, Point point) {
    point = point.last();
    points.add(point);
  }

  public List<Point> points() {
    return Collections.unmodifiableList(points);
  }
}
