package ladder.domain.ladder.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.line.point.LinePoint;

public class LineGenerator {

  public List<LinePoint> generateNotConnectedPoints (int countOfPerson) {
    return IntStream.range(0, countOfPerson)
        .mapToObj(LinePoint::new)
        .collect(Collectors.toUnmodifiableList());
  }
}
