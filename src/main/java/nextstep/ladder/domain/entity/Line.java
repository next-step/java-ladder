package nextstep.ladder.domain.entity;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {

  private static final int ONE_STEP = 1;
  private static final int INIT = 1;

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

                      if(isThisDirection(now - ONE_STEP)) {
                        return now - ONE_STEP;
                      }

                      if(isThisDirection(now)) {
                        return now + ONE_STEP;
                      }

                      return now;
                     })
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
  }

  private boolean isThisDirection(int index) {
    Point point = points.get(index);
    return point.hasWay();
  }
}
