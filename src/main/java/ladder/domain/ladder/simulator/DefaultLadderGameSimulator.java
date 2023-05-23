package ladder.domain.ladder.simulator;

import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.line.point.LadderPointDirection;
import ladder.domain.ladder.line.point.LinePoint;
import ladder.domain.ladder.reward.LadderGameReward;
import ladder.domain.ladder.reward.LadderGameRewardInfo;
import ladder.domain.player.Player;
import ladder.domain.result.LadderGamePlayerResult;

public class DefaultLadderGameSimulator implements LadderGameSimulator {

  @Override
  public LadderGamePlayerResult simulateSinglePlayer(Player player, Ladder ladder, LadderGameRewardInfo rewardInfo) {
    while (player.getCurrentHeight() < ladder.getLadderHeight()) {
      final LinePoint currentPoint = ladder.getPointAt(player.getCurrentHeight(), player.getCurrentLine());
      LadderPointDirection direction = currentPoint.getPointDirection();
      player.move(direction);
    }

    int finalLineIndex = player.getCurrentLine();
    LadderGameReward reward = rewardInfo.getRewardAt(finalLineIndex);

    return new LadderGamePlayerResult(player, reward);
  }
}
