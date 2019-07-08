package ladder.impl;

import java.util.ArrayList;
import java.util.List;
import ladder.LadderGenerator;

public class DefaultLadderGenerator implements LadderGenerator {

  @Override
  public DefaultLadder generate(int countOfPlayer, int ladderHeight) {
    List<LadderLine> ladderLines = new ArrayList<>();
    for (int i = 0; i < ladderHeight; i++) {
      ladderLines.add(LadderLine.of(countOfPlayer));
    }
    return DefaultLadder.of(ladderLines, countOfPlayer);
  }
}
