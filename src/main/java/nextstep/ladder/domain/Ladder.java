package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

  private final List<Line> lines;

  public Ladder(int height, int countOfPerson) {
    this(lines(height, countOfPerson));
  }

  public Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public List<Line> lines() {
    return Collections.unmodifiableList(lines);
  }

  private static List<Line> lines(int height, int countOfPerson) {
    return IntStream.range(0, height)
        .mapToObj(number -> new Line(countOfPerson))
        .collect(Collectors.toList());
  }
}
