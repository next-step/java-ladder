package laddergame.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

  private final List<Line> lines;

  public Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public static Ladder createByHeightAndCountOfPerson(
      PositiveNumber height, int countOfPerson) {

    List<Line> lines = Stream.generate(() -> Line.createByCountOfPerson(countOfPerson))
        .limit(height.getValue()).collect(
            Collectors.toList());

    return new Ladder(lines);

  }

  public List<Line> getLines() {
    return Collections.unmodifiableList(lines);
  }
}
