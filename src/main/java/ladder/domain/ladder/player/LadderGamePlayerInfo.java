package ladder.domain.ladder.player;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import ladder.domain.player.Player;

public class LadderGamePlayerInfo {

  private final List<Player> players;

  public LadderGamePlayerInfo(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
  }

  public LadderGamePlayerInfo(Set<Player> players) {
    this.players = List.copyOf(players);
  }

  public int getPlayerSize() {
    return players.size();
  }

  public List<Player> getPlayers() {
    return players;
  }
}
