package ladder.domain.ladder;

import java.util.List;

public interface LadderGenerator {
  List<Line> generateLadderLines(int playerCnt, int ladderHeight);
}
