package ladder.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LadderSolver {

  private static final Logger log = LoggerFactory.getLogger(LadderSolver.class);

  public static List<Integer> calculate(int participateCount, Set<Line> lines) {
    List<Integer> indexes = IntStream.range(0, participateCount).boxed()
        .collect(Collectors.toList());
    List<Line> orderedLines = lines.stream()
        .sorted(Comparator.comparingInt(line -> line.getRow().getValue()))
        .collect(Collectors.toList());
    for (Line line : orderedLines) {
      log.debug("수평 사다리인 Line 이 있어 {} 과 {} 이 swap 한다",
          line.getColumn().getValue(),
          line.getColumn().getValue() + 1
      );
      Collections.swap(indexes, line.getColumn().getValue(), line.getColumn().getValue() + 1);
      log.debug("{}", indexes);
    }
    return indexes;
  }
}
