package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Players {

  private final List<Name> players;

  public Players(List<Name> players) {
    this.players = players;
  }

  public List<Name> names() {
    return Collections.unmodifiableList(players);
  }

  public Name player(int index) {
    return players.get(index);
  }
}
