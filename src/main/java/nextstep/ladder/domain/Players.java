package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Players {
  Map<PlayerName, Player> players;

  public Players(Map<PlayerName, Player> players) {
    this.players = players;
  }

  public Player getPlayer(PlayerName playerName) {
    return this.players.get(playerName);
  }

  public Player getPlayer(Player player) {
    return this.players.get(player.getPlayerName());
  }

  public List<Player> getPlayers() {
    List<Player> playerList = new ArrayList<>(this.players.values());
    Collections.sort(playerList, Comparator.comparingInt(Player::getOrder));
    return playerList;
  }

  public int size() {
    return this.players.size();
  }
}
