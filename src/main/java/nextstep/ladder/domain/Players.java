package nextstep.ladder.domain;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;

public class Players {
  private final Map<PlayerName, Player> players;

  public Players(List<Player> players) {
    this(players.stream().collect(toMap(Player::getPlayerName, player -> player)));
  }

  public Players(Map<PlayerName, Player> players) {
    this.players = players;
  }

  public Player getPlayer(String playerName) {
    return this.players.get(playerName);
  }
}
