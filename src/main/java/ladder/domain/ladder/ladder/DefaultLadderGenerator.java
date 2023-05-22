package ladder.domain.ladder.ladder;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.line.HorizontalLadderLine;
import ladder.domain.ladder.line.connector.BinaryRandomlyLadderLineConnector;
import ladder.domain.random.DefaultRandomBooleanGenerator;

public class DefaultLadderGenerator implements LadderGenerator {

  private final BinaryRandomlyLadderLineConnector lineConnector;
  private static final int MIN_LADDER_HEIGHT_SIZE = 1;

  public DefaultLadderGenerator() {
    this.lineConnector = new BinaryRandomlyLadderLineConnector(new DefaultRandomBooleanGenerator());
  }

  @Override
  public Ladder generateLadderLines(int playerCnt, int ladderHeight) {
    throwIfHeightNotValid(ladderHeight);
    final List<HorizontalLadderLine> lines = IntStream.range(0, ladderHeight)
        .mapToObj(i -> new HorizontalLadderLine(playerCnt))
        .map(this::connectPoint)
        .collect(Collectors.toUnmodifiableList());

    return new Ladder(lines);
  }

  private void throwIfHeightNotValid(int ladderHeight) {
    if(MIN_LADDER_HEIGHT_SIZE > ladderHeight) {
      throw new LadderGameException(ExceptionCode.MIN_LADDER_HEIGHT_REQUIRED);
    }
  }

  /**
   * 라인을 연결할 수 있는 경우애서 랜덤으로 연결한다.
   */
  private HorizontalLadderLine connectPoint(HorizontalLadderLine line) {
    int pointSize = line.getPointSize();
    for (int pointIdx = 0; pointIdx < pointSize; pointIdx++) {
      lineConnector.connectNextPoint(line, pointIdx);
    }

    return line;
  }
}
