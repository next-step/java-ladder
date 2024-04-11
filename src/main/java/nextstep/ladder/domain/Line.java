package nextstep.ladder.domain;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

  private final List<Point> points;

  public Line (int width) {
    this.points = IntStream.range(0, width)
        .mapToObj(i -> getRandomBoolean())
        .collect(ArrayList::new, (list, element) -> {
          if (list.isEmpty() || list.get(list.size() - 1).isNotBridge()) {
            list.add(Point.of(element));
          } else {
            list.add(Point.of(FALSE));
          }
        }, ArrayList::addAll);
  }

  private Boolean getRandomBoolean() {
    return Math.random() < 0.5;
  }

  public String getLineString() {
   return String.format("|%s|", points.stream().map(point -> point.isNotBridge() ? "     " : "-----")
        .collect(Collectors.joining("|")));
  }

}
