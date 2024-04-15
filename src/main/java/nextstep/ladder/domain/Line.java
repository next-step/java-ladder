package nextstep.ladder.domain;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

  private final List<Point> points;

  public Line (int width, BooleanGenerator booleanGenerator) {
    this.points = makePoints(width, booleanGenerator);
  }

  private static List<Point> makePoints(int width, BooleanGenerator booleanGenerator) {
    return IntStream.range(0, width)
        .mapToObj(i -> booleanGenerator.generate())
        .collect(ArrayList::new, (list, element) -> {
          if (list.isEmpty() || list.get(list.size() - 1).isNotBridge()) {
            list.add(Point.of(element));
          } else {
            list.add(Point.of(FALSE));
          }
        }, ArrayList::addAll);
  }

  public List<Point> getPoints() {
    return points;
  }
}
