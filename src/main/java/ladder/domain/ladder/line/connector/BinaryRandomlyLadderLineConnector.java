package ladder.domain.ladder.line.connector;

import ladder.domain.ladder.line.HorizontalLadderLine;
import ladder.domain.ladder.line.point.LinePoint;
import ladder.domain.random.RandomBooleanGenerator;

public class BinaryRandomlyLadderLineConnector implements LadderLineConnector {

  private final RandomBooleanGenerator randomBooleanGenerator;

  public BinaryRandomlyLadderLineConnector(RandomBooleanGenerator randomBooleanGenerator) {
    this.randomBooleanGenerator = randomBooleanGenerator;
  }

  public HorizontalLadderLine connectNextPoint(HorizontalLadderLine line, int linePointIdx) {
    if (!isConnectable()) {
      return line;
    }

    final LinePoint point = line.getPointAt(linePointIdx);
    if (line.isEndPoint(point)) {
      return line;
    }

    final LinePoint nextPoint = line.getPointAt(linePointIdx + 1);
    if (line.isStartPoint(nextPoint)) {
      point.connect(nextPoint);
      return line;
    }

    // 이전 라인이 이어져있으면 넘어감
    if (line.isPreviousPointConnected(point)) {
      return line;
    }

    point.connect(nextPoint);
    return line;
  }

  private boolean isConnectable() {
    return randomBooleanGenerator.getBoolean();
  }
}
