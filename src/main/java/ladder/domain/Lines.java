package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Lines {

  private final List<Line> lines;

  private Lines(List<Line> lines) {
    this.lines = lines;
  }

  public static Lines createLines(Height height, Participants participants,
      NextPointGenerationStrategy generationStrategy) {
    List<Line> lines = Stream.generate(() -> Line.createLine(participants.size(), generationStrategy))
        .limit(height.height())
        .collect(Collectors.toList());
    return new Lines(lines);
  }

  public Line getRow(int rowNumber) {
    return lines.get(rowNumber);
  }

  public int height() {
    return lines.size();
  }
}
