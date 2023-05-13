package ladder.domain.ladder;

import java.util.List;
import ladder.domain.Line.Line;

public interface LadderGenerator {
  List<Line> generateLadderLines(int playerCnt, int ladderHeight);
}
