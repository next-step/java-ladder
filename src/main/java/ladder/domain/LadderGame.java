package ladder.domain;

import java.util.List;
import ladder.domain.ladder.DefaultLadderGenerator;
import ladder.domain.ladder.LadderGenerator;
import ladder.domain.Line.Line;
import ladder.domain.player.Player;
import ladder.domain.player.PlayerGenerator;

public class LadderGame {

  private final List<Player> players;
  private final List<Line> ladderLines;

  public LadderGame (List<String> playerNames, int ladderHeight) {
    final PlayerGenerator playerGenerator = new PlayerGenerator();
    final LadderGenerator ladderGenerator = new DefaultLadderGenerator();

    this.players = playerGenerator.generatePlayerList(playerNames);
    this.ladderLines = ladderGenerator.generateLadderLines(playerNames.size(), ladderHeight);
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
