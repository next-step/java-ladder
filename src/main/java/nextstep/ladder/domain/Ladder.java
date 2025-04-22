package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

  private final List<Line> lines;

  private Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public static Ladder of(int height, int countOfPerson, PointGenerateStrategy strategy) {
    List<Line> lines = IntStream.range(0, height)
        .mapToObj(i -> new Line(countOfPerson, strategy))
        .collect(Collectors.toList());
    return new Ladder(lines);
  }

  public void printLadder() {
    lines.forEach(Line::printLine);
  }

  public int play(int startIndex) {
    return lines.stream().reduce(startIndex, (index, line) -> line.move(index), (a, b) -> b);
  }
}
