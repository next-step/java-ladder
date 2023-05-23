package ladder.domain.ladder.player;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import ladder.domain.player.Player;
import ladder.domain.result.LadderGamePlayerResult;
import ladder.domain.result.LadderGameResult;

public class LadderGamePlayerInfo {
  private final List<Player> players;

  public LadderGamePlayerInfo(List<Player> players) {
    this.players = Collections.unmodifiableList(players);
  }

  public List<Player> getPlayers() {
    return players;
  }

  public LadderGameResult playAll(Function<Player, LadderGamePlayerResult> hof) {
    final List<LadderGamePlayerResult> playerResults = this.players.stream()
        .map(hof)
        .collect(Collectors.toUnmodifiableList());

    return new LadderGameResult(playerResults);
  }
}
