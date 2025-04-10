package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGenerator {
  public static Ladder generate(int participants, int height) {
    List<Line> lines = IntStream.range(0, height)
        .mapToObj(i -> new Line(participants))
        .collect(Collectors.toList());
    return new Ladder(lines);
  }

}
