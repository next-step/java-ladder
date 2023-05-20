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
  private final LadderGamePlayerInfo playerInfo;
  private final LadderGameRewordInfo gameReword;
  private final LadderGameSimulator gameSimulator;

  public LadderGame(List<String> playerNames, List<String> rewords, int ladderHeight, LadderGameSetting gameSetting) {
    this.playerInfo = gameSetting.generatePlayer(playerNames);
    this.ladder = gameSetting.generateLadderLine(this.playerInfo.getPlayerSize(), ladderHeight);
    this.gameSimulator = gameSetting.getGameSimulator();
    this.gameReword = new LadderGameRewordInfo(rewords);
  }

  public LadderGameResult play() {
    List<LadderGamePlayerResult> playerResults = this.playerInfo.getPlayers().stream()
        .map(player -> this.gameSimulator.simulateSinglePlayer(player, ladder, gameReword))
        .collect(Collectors.toList());

    return new LadderGameResult(playerResults);
  }

  public LadderGamePlayerInfo getPlayerInfo() {
    return playerInfo;
  }

  public Ladder getLadder() {
    return ladder;
  }
}
