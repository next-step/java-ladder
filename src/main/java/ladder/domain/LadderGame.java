package ladder.domain;

import java.util.List;
import ladder.domain.Line.Line;
import ladder.domain.ladder.setting.LadderGameSetting;
import ladder.domain.player.Player;

public class LadderGame {

  private final List<Player> players;
  private final List<Line> ladderLines;

  public LadderGame(List<String> playerNames, int ladderHeight, LadderGameSetting gameSetting) {
    this.players = gameSetting.generatePlayer(playerNames);
    this.ladderLines = gameSetting.generateLadderLine(this.players.size(), ladderHeight);
  }

  public void play() {
    // TODO
  }

  public List<Player> getPlayers() {
    return players;
  }

  public List<Line> getLadderLines() {
    return ladderLines;
  }
}
