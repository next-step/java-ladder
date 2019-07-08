package ladder;

import ladder.impl.DefaultLadderGenerator;
import ladder.impl.LadderHeight;
import ladder.impl.Players;

public class LadderGame {

  private LadderGenerator ladderGenerator;

  public LadderGame(DefaultLadderGenerator defaultLadderGenerator) {
    ladderGenerator = defaultLadderGenerator;
  }

  public static LadderGame of(DefaultLadderGenerator defaultLadderGenerator) {
    return new LadderGame(defaultLadderGenerator);
  }

  public Ladder generate(Players players, LadderHeight ladderHeight) {
    return ladderGenerator.generate(players.count(), ladderHeight.value());
  }

}
