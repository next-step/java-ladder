package ladder.domain.ladder.player;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import ladder.domain.player.Player;

public class LadderGamePlayerInfo {

  private final List<Player> players;
  private final Map<String, Player> playerMap;

  public LadderGamePlayerInfo(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
    this.playerMap = this.players.stream()
        .collect(Collectors.toMap(Player::getPlayerName, Function.identity()));
  }

  public int getPlayerSize() {
    return players.size();
  }

  public List<Player> getPlayers() {
    return players;
  }
}
