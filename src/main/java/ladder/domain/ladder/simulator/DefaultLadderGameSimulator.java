package ladder.domain.ladder.simulator;

import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.line.point.LadderPointDirection;
import ladder.domain.ladder.line.point.LinePoint;
import ladder.domain.ladder.reword.LadderGameReword;
import ladder.domain.ladder.reword.LadderGameRewordInfo;
import ladder.domain.player.Player;
import ladder.domain.result.LadderGamePlayerResult;

public class DefaultLadderGameSimulator implements LadderGameSimulator {

  @Override
  public LadderGamePlayerResult simulateSinglePlayer(Player player, Ladder ladder, LadderGameRewordInfo rewordInfo) {
    while (player.getCurrentHeight() < ladder.getLadderHeight()) {
      final LinePoint currentPoint = ladder.getPointAt(player);
      LadderPointDirection direction = currentPoint.getPointDirection();
      player.move(direction);
    }

    int finalLineIndex = player.getCurrentLine();
    LadderGameReword reword = rewordInfo.getRewordAt(finalLineIndex);

    return new LadderGamePlayerResult(player, reword);
  }
}
