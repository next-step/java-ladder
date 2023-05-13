package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Line.Line;

public class DefaultLadderGenerator implements LadderGenerator {

  @Override
  public List<Line> generateLadderLines(int playerCnt, int ladderHeight) {
    return IntStream.range(0, ladderHeight)
        .mapToObj(i -> new Line(playerCnt))
        .map(this::connectLadderInLineIfPossible)
        .collect(Collectors.toList());
  }

  private Line connectLadderInLineIfPossible(Line line) {
    return line;
  }
}
