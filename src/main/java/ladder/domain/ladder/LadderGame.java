package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.ladder.ladder.Ladder;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.ladder.reword.LadderGameRewordInfo;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.ladder.simulator.LadderGameSimulator;
import ladder.domain.result.LadderGamePlayerResult;
import ladder.domain.result.LadderGameResult;

public class LadderGame {

  private final Ladder ladder;
  private final LadderGameSimulator gameSimulator;

  public LadderGame(int playerSize, int ladderHeight, LadderGameSetting gameSetting) {
    this.ladder = gameSetting.generateLadderLine(playerSize, ladderHeight);
    this.gameSimulator = gameSetting.getGameSimulator();
  }

  public LadderGameResult play(LadderGamePlayerInfo playerInfo, LadderGameRewordInfo gameRewordInfo) {
    List<LadderGamePlayerResult> playerResults = playerInfo.getPlayers().stream()
        .map(player -> this.gameSimulator.simulateSinglePlayer(player, ladder, gameRewordInfo))
        .collect(Collectors.toList());

    return new LadderGameResult(playerResults);
  }

  public Ladder getLadder() {
    return ladder;
  }
}
