package ladder.model.line;

import ladder.model.Height;
import ladder.model.result.InterimResults;
import ladder.strategy.LadderPointsStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
  private static final int ZERO = 0;

  private final List<Line> lines;

  private Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public static Ladder makeLines(Height height, int countOfPerson, LadderPointsStrategy strategy) {
    List<Line> makingLines = IntStream.range(ZERO, height.height())
      .mapToObj(number -> Line.init(countOfPerson, strategy))
      .collect(Collectors.toList());
      ;
    return new Ladder(Collections.unmodifiableList(makingLines));
  }

  //  public InterimResults checkLinesResult(int size) {
//    InterimResults interimResults = InterimResults.makeInterimResults(size);
//
//    for (Line line : lines) {
//      interimResults = line.move(interimResults);
//    }
//
//    return interimResults;
//  }

  public List<Line> specificLines() {
    return lines;
  }

}
