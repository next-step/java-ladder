package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderFactory {

  public static Ladder createLadder(int ladderLength, int playerCount, LadderBarStatusDecider ladderBarStatusDecider) {
    Map<LadderPoint, LadderBarStatus> ladder = new HashMap<>();

    for (int row = 0; row < ladderLength; row++) {
      LadderBarStatus cache = LadderBarStatus.EMPTY;
      for (int column = 0; column < playerCount - 1; column++) {
        cache = ladderBarStatusDecider.decide(cache);
        ladder.put(new LadderPoint(row, ladderLength, column, playerCount), cache);
      }
    }

    return new Ladder(ladder, ladderLength);
  }
}
