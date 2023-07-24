package nextstep.ladder.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {
  private final List<Player> players;

  public Players(List<Player> players) {
    this.players = players;
  }

  public Player getPlayer(PlayerName playerName) {
    return this.players.stream()
        .filter(player -> player.getPlayerName().equals(playerName))
        .findFirst()
        .orElseThrow();
  }

  public List<Player> asList() {
    return this.players;
  }

  public int size() {
    return this.players.size();
  }

  public Player get(int index) {
    return this.players.get(index);
  }
}
