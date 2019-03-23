package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

  private List<Line> lines;

  public Ladder(int countOfPerson, int height) {

    if (height <= 0) {
      throw new IllegalArgumentException();
    }
    this.lines = IntStream.range(0, height)
        .mapToObj(index -> new Line(countOfPerson))
        .collect(Collectors.toList());
  }

  public List<Line> getLines() {
    return lines;
  }
}
