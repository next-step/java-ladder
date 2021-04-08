package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {

  private final List<Line> lines;

  private Lines(List<Line> lines) {
    this.lines = lines;
  }

  public static Lines setup(int countOfPerson, int height, LineStrategy lineStrategy) {
    return new Lines(Stream.generate(() ->
        Line.generate(countOfPerson, lineStrategy)).limit(height).collect(Collectors.toList()));
  }

  public List<Line> getLines() {
    return Collections.unmodifiableList(lines);
  }

  public int findFinalPosition(int start) {
    int position = start;
    for (Line line : lines) {
      position = line.move(position);
    }
    return position;
  }
}
