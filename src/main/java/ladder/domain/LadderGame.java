package ladder.domain;

import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.player.LadderGamePlayerInfo;
import ladder.domain.ladder.reword.LadderGameRewordInfo;
import ladder.domain.ladder.setting.LadderGameSetting;

public class LadderGame {

  private final LadderGamePlayerInfo playerInfo;
  private final Ladder ladder;
  private final LadderGameRewordInfo gameReword;

  public LadderGame(List<String> playerNames, List<String> rewords, int ladderHeight, LadderGameSetting gameSetting) {
    this.playerInfo = gameSetting.generatePlayer(playerNames);
    this.ladder = gameSetting.generateLadderLine(this.playerInfo.getPlayerSize(), ladderHeight);
    this.gameReword = gameSetting.generateReword(rewords);
  }

  public void play() {
    // TODO
  }

  public LadderGamePlayerInfo getPlayerInfo() {
    return playerInfo;
  }

  public Ladder getLadder() {
    return ladder;
  }

  public int getLadderLineSize () {
    return ladder.getLineSize();
  }
}
