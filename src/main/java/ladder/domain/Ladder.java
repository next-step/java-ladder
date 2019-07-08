package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Ladder {

  private List<Line> lines;

  private Ladder(List<Line> lines) {
    this.lines = Collections.unmodifiableList(lines);
  }


  public static Ladder of(int height, int numOfPlayers) {
    List<Line> lines = IntStream.range(0, height)
        .mapToObj(i -> Line.of(numOfPlayers))
        .collect(toList());
    return new Ladder(lines);
  }

  public List<Line> getLines() {
    return lines;
  }
}
