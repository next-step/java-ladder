package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

  private final List<Line> ladder = new ArrayList<>();

  public Ladder(Players players, int height) {
    int countOfPerson = players.names().size();

    IntStream.range(0, height)
        .forEach(i -> ladder.add(new Line(countOfPerson)));
  }

  public List<Line> lines() {
    return ladder;
  }
}
