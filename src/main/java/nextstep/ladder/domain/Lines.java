package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

  private final List<Line> lines;

  private Lines(List<Line> lines) {
    this.lines = lines;
  }

  public static Lines of(int height, int countOfPerson) {
    return new Lines(IntStream.range(0, height)
        .mapToObj(number -> Line.from(countOfPerson, new RandomPointStrategy()))
        .collect(Collectors.toList()));
  }

  public List<Line> lines() {
    return Collections.unmodifiableList(lines);
  }

}
