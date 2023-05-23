package ladder.domain.result;

import ladder.domain.ladder.reward.LadderGameReward;
import ladder.domain.player.Player;

public class LadderGamePlayerResult {

  private final Player player;
  private final LadderGameReward reward;

  public LadderGamePlayerResult(Player player, LadderGameReward reward) {
    this.player = player;
    this.reward = reward;
  }

  public String getPlayerName() {
    return player.getPlayerName();
  }

  public int getRewardPrize() {
    return reward.getRewardPrize();
  }
}
