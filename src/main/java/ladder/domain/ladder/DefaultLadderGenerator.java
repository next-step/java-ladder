package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Line.Line;
import ladder.domain.Line.LinePoint;
import ladder.domain.random.DefaultRandomBooleanGenerator;
import ladder.domain.random.RandomBooleanGenerator;

public class DefaultLadderGenerator implements LadderGenerator {

  private final RandomBooleanGenerator randomBooleanGenerator;

  public DefaultLadderGenerator() {
    this.randomBooleanGenerator = new DefaultRandomBooleanGenerator();
  }

  @Override
  public List<Line> generateLadderLines(int playerCnt, int ladderHeight) {
    return IntStream.range(0, ladderHeight)
        .mapToObj(i -> new Line(playerCnt))
        .map(this::connectPointInLineIfPossible)
        .collect(Collectors.toList());
  }

  /**
   * 라인을 연결할 수 있는 경우애서 랜덤으로 연결한다.
   */
  private Line connectPointInLineIfPossible(Line line) {
    int pointSize = line.getPointSize();
    for (int i = 0; i < pointSize; i++) {
      connectPointIfPossible(line, i);
    }

    return line;
  }

  private void connectPointIfPossible(Line line, int linePointIdx) {
    final boolean allowedToConnect = randomBooleanGenerator.getBoolean();
    if (!allowedToConnect) {
      return;
    }

    final LinePoint point = line.getPoint(linePointIdx);
    if (point.isEndPoint()) {
      return;
    }

    final LinePoint nextPoint = line.getPoint(linePointIdx + 1);
    if (point.isStartPoint()) {
      point.connect(nextPoint);
      return;
    }

    // 이전 라인이 이어져있으면 넘어감
    if (line.isPrePointConnected(point)) {
      return;
    }

    point.connect(nextPoint);
  }
}
