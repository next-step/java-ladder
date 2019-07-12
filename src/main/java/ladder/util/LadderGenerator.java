package ladder.util;

import ladder.domain.Ladder;

public class LadderGenerator {

  public static Ladder generate(int height, int countOfPlayers) {
    return Ladder.of(height, countOfPlayers);
  }

}
