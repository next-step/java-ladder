package ladder.domain.ladder.simulator;

import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.reword.LadderGameRewordInfo;
import ladder.domain.player.Player;
import ladder.domain.result.LadderGamePlayerResult;

public interface LadderGameSimulator {
  LadderGamePlayerResult simulateSinglePlayer(Player player, Ladder ladder, LadderGameRewordInfo rewordInfo);
}
