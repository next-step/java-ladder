package nextstep.ladder.domain.entity;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

  private static final int INIT = 0;

  private final List<Point> points;

  public Line(List<Point> points) {
    this.points = points;
  }

  public Stream<Point> stream() {
    return points.stream();
  }

  public int size() {
    return points.size();
  }

  public int move(int startingPoint) {
    return IntStream.range(INIT, points.size())
                    .filter(index -> index  == startingPoint)
                    .map(now -> {
                      Point nowPoint = points.get(now);
                      int direction = nowPoint.move();
                      return now + direction;
                    })
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
  }
}
