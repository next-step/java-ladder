package ladder.model.result;

import ladder.model.member.Player;
import ladder.model.prize.Prize;

public class LadderTotalResult {
  private final Player player;
  private final Prize prize;

  public LadderTotalResult(Player player, Prize prize) {
    this.player = player;
    this.prize = prize;
  }

  public Player player() {
    return player;
  }

  public Prize prize() {
    return prize;
  }
}
