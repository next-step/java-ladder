package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static ladder.domain.Point.START_INDEX;

public class Ladder {

  private final List<Line> lines;

  private Ladder(List<Line> lines) {
    this.lines = Collections.unmodifiableList(lines);
  }

  public static Ladder of(int height, int countOfPlayers) {
    List<Line> lines = IntStream.range(START_INDEX, height)
        .mapToObj(i -> Line.of(countOfPlayers))
        .collect(toList());
    return new Ladder(lines);
  }

  int result(int index) {
    int i = index;
    for (Line line : lines) {
      i = line.move(i);
    }
    return i;
  }

  public List<Line> getLines() {
    return lines;
  }
}
