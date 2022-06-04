package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

  private final List<Line> lines;

  public Lines(List<Line> lines) {
    this.lines = lines;
  }

  public static Lines of(int height, int numberOfPlayers) {
    return new Lines(IntStream.range(0, height)
        .mapToObj(number -> Line.from(numberOfPlayers, new RandomPointStrategy()))
        .collect(Collectors.toList()));
  }

  public int move(int startPoint) {
    int result = startPoint;
    for (Line line : lines) {
      result = line.move(result);
    }
    return result;
  }

  public List<Line> lines() {
    return Collections.unmodifiableList(lines);
  }
}
