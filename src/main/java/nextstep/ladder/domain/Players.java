package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

  private List<Player> players;

  private Players(List<Player> players) {
    this.players = players;
  }

  public static Players withNames(List<String> names) {
    return new Players(
        IntStream.range(0, names.size())
            .mapToObj(position -> new Player(names.get(position), position))
            .collect(Collectors.toList())
    );
  }

  public static Players of(List<Player> players) {
    return new Players(players);
  }

  public List<Player> getPlayers() {
    return players;
  }
}
