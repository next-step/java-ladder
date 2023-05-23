package ladder.testDouble.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.ladder.LadderGenerator;
import ladder.domain.ladder.line.HorizontalLadderLine;

/**
 * 사다리에 아무 연결이 없는 double
 *
 * |     |     |     |
 * |     |     |     |
 * |     |     |     |
 * |     |     |     |
 * |     |     |     |
 */
public class NotConnectedLadderGenerator implements LadderGenerator {

  @Override
  public Ladder generateLadderLines(int playerCnt, int ladderHeight) {
    List<HorizontalLadderLine> lines = IntStream.range(0, ladderHeight)
        .mapToObj(i -> new HorizontalLadderLine(playerCnt))
        .collect(Collectors.toUnmodifiableList());

    return new Ladder(lines);
  }
}
