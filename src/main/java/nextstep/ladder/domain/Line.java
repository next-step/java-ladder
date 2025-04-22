package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

  private final List<Boolean> points;

  public Line(int countOfPerson, PointGenerateStrategy strategy) {
    this.points = Stream.iterate(false, prev -> !prev)
        .limit(countOfPerson - 1)
        .map(prev -> {
          boolean current = strategy.generate();
          return !prev && current;
        })
        .collect(Collectors.toList());
  }

  public boolean generateNextLine(boolean previousHasLine,
      PointGenerateStrategy strategy) {
    if (previousHasLine) {
      return false;
    }
    return strategy.generate();
  }

  public void printLine() {
    points.stream().map(point -> "|" + (point ? "-----" : "     "))
        .forEach(System.out::print);
    System.out.println("|");
  }

  public int move(int index) {
    if (index < points.size() && points.get(index)) {
      return index + 1;
    }
    if (index > 0 && points.get(index - 1)) {
      return index - 1;
    }
    return index;
  }
}
