package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

  private List<Player> players;

  public Players(List<String> names) {
    players = IntStream.range(0, names.size())
        .mapToObj(position -> new Player(names.get(position), position))
        .collect(Collectors.toList());
  }

  public List<Player> getPlayers() {
    return players;
  }
}
