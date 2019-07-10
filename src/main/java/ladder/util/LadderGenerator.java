package ladder.util;

import ladder.domain.Ladder;
import ladder.domain.Players;

public class LadderGenerator {

  public static Ladder generate(int height, Players players) {
    return Ladder.of(height, players);
  }

}
