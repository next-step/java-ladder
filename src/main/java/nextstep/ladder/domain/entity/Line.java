package nextstep.ladder.domain.entity;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

  private static final int INIT = 1;
  private static final int LEFT = -1;

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
    return IntStream.range(INIT, points.size() + INIT)
                    .filter(index -> index  == startingPoint)
                    .map(now -> {
                      Point nowPoint = points.get(now);
                      int direction = nowPoint.findDirection(points.get(now + LEFT));
                      return now + direction;
                    })
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
  }

}
