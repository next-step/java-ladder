package ladder.domain.ladder.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineGenerator {

  public List<LinePoint> generateNotConnectedPoints (int countOfPerson) {
    final int lastIdx = countOfPerson - 1;
    return IntStream.range(0, countOfPerson)
        .mapToObj(i -> createLinePoint(i, lastIdx))
        .collect(Collectors.toList());
  }

  private LinePoint createLinePoint(int index, int lastIndex) {
    if (index  == 0) {
      return new LinePoint(index, true, false);
    }

    if (index == lastIndex) {
      return new LinePoint(index, false, true);
    }

    return new LinePoint(index);
  }
}
