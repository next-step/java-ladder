package ladder.domain.ladder;

import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.ladder.LadderGenerator;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.ladder.reward.LadderGameRewardInfo;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.ladder.simulator.LadderGameSimulator;
import ladder.domain.result.LadderGameResult;

public class LadderGame {

  private final Ladder ladder;
  private final LadderGameSimulator gameSimulator;

  public LadderGame (int playerSize, int ladderHeight, LadderGameSetting gameSetting) {
    final LadderGenerator ladderGenerator = gameSetting.getLadderGenerator();

    this.ladder = ladderGenerator.generateLadderLines(playerSize, ladderHeight);
    this.gameSimulator = gameSetting.getGameSimulator();
  }

  public LadderGameResult play (LadderGamePlayerInfo playerInfo, LadderGameRewardInfo gameRewardInfo) {
    return playerInfo.playAll(player -> this.gameSimulator.simulateSinglePlayer(player, ladder, gameRewardInfo));
  }

  public Ladder getLadder() {
    return ladder;
  }
}
