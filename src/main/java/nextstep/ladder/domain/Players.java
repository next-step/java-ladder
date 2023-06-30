package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Players {
  private final Map<PlayerName, Player> players;
  private List<Player> cache;

  public Players(Map<PlayerName, Player> players) {
    this.players = players;
  }

  public Player getPlayer(PlayerName playerName) {
    return this.players.get(playerName);
  }

  public List<Player> getPlayers() {
    if (this.cache != null) {
      return this.cache;
    }

    List<Player> playerList = new ArrayList<>(this.players.values());
    Collections.sort(playerList, Comparator.comparingInt(Player::getOrder));
    this.cache = playerList;
    return this.cache;
  }

  public int size() {
    return this.players.size();
  }
}
