package ladder.testDouble;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.Line.Line;

/**
 * 첫번째 라인의 두 포인트만 연속으로 연결되어있는
 * 사다리를 생성하는 구현체
 *
 * eg)
 * |----|----|    |
 * |    |    |    |
 * |    |    |    |
 */
public class LadderFirstLineTwoConnectedLineGenerator implements LadderGenerator {

  @Override
  public List<Line> generateLadderLines(int playerCnt, int ladderHeight) {
    List<Line> lines = IntStream.range(0, ladderHeight)
        .mapToObj(i -> new Line(playerCnt))
        .collect(Collectors.toList());

    connectFirstTwo(lines);
    return lines;
  }

  private void connectFirstTwo(List<Line> lines) {
    Line line = lines.get(0);
    line.connectRight(0);
    line.connectRight(1);
  }
}
