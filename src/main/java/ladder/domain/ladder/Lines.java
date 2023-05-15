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

  public static Lines createLines(LadderSizeInfo sizeInfo,
      NextPointGenerationStrategy generationStrategy) {
    List<Line> lines = Stream.generate(() -> Line.createLine(sizeInfo.getNumberOfParticipants(), generationStrategy))
        .limit(sizeInfo.getHeight())
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

    for (int i = 0; i < height(); i++) {
      indexOfResult = updateIndexOfResult(indexOfResult, i);
    }

    return indexOfResult;
  }

  private int updateIndexOfResult(int indexOfResult, int i) {
    if (getRow(i).isRightConnected(indexOfResult)) {
      return indexOfResult + 1;
    }

    if (isNotFirstIndex(indexOfResult) && getRow(i).isLeftConnected(indexOfResult)) {
      return indexOfResult - 1;
    }

    return indexOfResult;
  }

  private static boolean isNotFirstIndex(int indexOfResult) {
    return indexOfResult > 0;
  }

}
