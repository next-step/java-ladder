package ladder.model.line;

import ladder.model.Height;
import ladder.model.result.InterimResults;
import ladder.strategy.LadderPointsStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {
  private static final int ZERO = 0;

  private final List<Line> lines;

  private Lines(List<Line> lines) {
    this.lines = lines;
  }

  public static Lines makeLines(Height height, int countOfPerson, LadderPointsStrategy strategy) {
    List<Line> makingLines = new ArrayList<>();
    IntStream.range(ZERO, height.height())
      .forEach(number ->
        makingLines.add(new Line(countOfPerson, strategy))
      );
    return new Lines(Collections.unmodifiableList(makingLines));
  }

  public InterimResults checkLinesResult(int size) {
    InterimResults interimResults = InterimResults.makeInterimResults(size);

    for (Line line : lines) {
      interimResults = line.move(interimResults);
    }

    return interimResults;
  }

  public List<Line> specificLines() {
    return lines;
  }

}
