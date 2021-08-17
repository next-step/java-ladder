package ladderGame.step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

  private final List<Player> players;

  public Players(final List<Player> players) {
    this.players = Collections.unmodifiableList(players);
  }

  public int count(){
    return players.size();
  }

  public List<Player> toList() {
    return new ArrayList<>(players);
  }
}