package ladder.domain.result;

import ladder.domain.ladder.reword.LadderGameReword;
import ladder.domain.player.Player;

public class LadderGamePlayerResult {

  private final Player player;
  private final LadderGameReword reword;

  public LadderGamePlayerResult(Player player, LadderGameReword reword) {
    this.player = player;
    this.reword = reword;
  }

  public String getPlayerName() {
    return player.getPlayerName();
  }

  public int getRewordPrize() {
    return reword.getRewordPrize();
  }
}
