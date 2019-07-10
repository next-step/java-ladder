package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static ladder.domain.Point.START_INDEX;

public class Ladder {

  private List<Line> lines;
  private Players players;

  private Ladder(List<Line> lines, Players players) {
    this.lines = Collections.unmodifiableList(lines);
    this.players = players;
  }


  public static Ladder of(int height, Players players) {
    List<Line> lines = IntStream.range(START_INDEX, height)
        .mapToObj(i -> Line.of(players.size()))
        .collect(toList());
    return new Ladder(lines, players);
  }

  public Players result() {
    return lines.stream()
        .map(players::move)
        .reduce((first, second) -> second)
        .orElseThrow(IllegalArgumentException::new);
  }

  public List<Line> getLines() {
    return lines;
  }
}
