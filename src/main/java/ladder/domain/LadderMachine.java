package ladder.domain;

import ladder.strategy.DirectionMoveStrategy;

public class LadderMachine {

  private LadderMachine() {}

  public static LadderGame createLadderGame(Users users, int ladderHeight) {
    LadderLine ladderLine = LadderLine.createPoints(users.countOfUser(), new DirectionMoveStrategy());
    Ladder ladder = new Ladder(ladderLine, ladderHeight);
    return new LadderGame(users, ladder);
  }

  public static LadderResult playLadderGame(LadderGame ladderGame, LadderRewards ladderRewards) {
    return ladderGame.play(ladderRewards);
  }
}
