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
    if (points.isEmpty()) {
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

  public int move(int index) {
    return moveRight(index) + moveLeft(index);
  }

  private int moveRight(int index) {
    if (index + 1 != points().size() && points.get(index + 1).isConnected()) {
      return 1;
    }
    return 0;
  }

  private int moveLeft(int index) {
    if (points.get(index).isConnected()) {
      return -1;
    }
    return 0;
  }
}
