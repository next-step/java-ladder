package ladder.domain.ladder.player;

import java.util.Collections;
import java.util.List;
import ladder.domain.player.Player;

public class LadderGamePlayerInfo {
  private final List<Player> players;
  public LadderGamePlayerInfo(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
  }

  public List<Player> getPlayers() {
    return players;
  }
}
