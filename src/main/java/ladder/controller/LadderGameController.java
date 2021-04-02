package ladder.controller;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import ladder.domain.LadderGame;
import ladder.domain.MatchOfPrize;

public class LadderGameController {

  private final LadderGame ladderGame;
  private final MatchOfPrize matchOfPrize;

  public LadderGameController(int height, String[] names, String[] prizes) {
    this(new LadderGame(height,names), new MatchOfPrize(prizes));
  }

  public LadderGameController(LadderGame ladderGame, MatchOfPrize matchOfPrize) {
    this.ladderGame = ladderGame;
    this.matchOfPrize = matchOfPrize;
  }

  public LadderGame getLadderGame() {
    return ladderGame;
  }
}
