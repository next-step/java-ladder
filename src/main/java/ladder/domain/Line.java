package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

  private final List<Point> points = new ArrayList<>();

  public Line(int countOfPerson) {
    IntStream.range(0, countOfPerson)
        .forEach(i -> points.add(connectPoint(new RandomConnect())));
  }

  public Point connectPoint(ConnectStrategy connectStrategy) {
    if (points.size() == 0) {
      return Point.DISCONNECT;
    }

    Point prePoint = points.get(points.size() - 1);
    if (prePoint.isConnected()) {
      return Point.DISCONNECT;
    }

    return Point.getPoint(connectStrategy.connect());
  }

  public List<Point> points() {
    return points;
  }
}
