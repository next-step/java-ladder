package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ladder.domain.participant.Participants;
import ladder.domain.strategy.NextPointGenerationStrategy;

public class Lines {

  private final List<Line> lines;

  private Lines(List<Line> lines) {
    this.lines = lines;
  }

  Lines(Line... lines) {
    this.lines = List.of(lines);
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

  public int getLastIndex(int startIndex) {
    int indexOfResult = startIndex;

    for (int rowNumber = 0; rowNumber < height(); rowNumber++) {
      indexOfResult = updateIndexOfResult(indexOfResult, rowNumber);
    }

    return indexOfResult;
  }

  private int updateIndexOfResult(int indexOfResult, int rowNumber) {
    if (getRow(rowNumber).isRightConnected(indexOfResult)) {
      return indexOfResult + 1;
    }

    if (getRow(rowNumber).isLeftConnected(indexOfResult)) {
      return indexOfResult - 1;
    }

    return indexOfResult;
  }



}
