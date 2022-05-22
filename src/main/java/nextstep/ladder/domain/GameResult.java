package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameResult {

  private final Map<Player, String> results;

  public GameResult() {
    this.results = new HashMap<>();
  }

  public void add(Player player, String endPoint) {
    results.put(player, endPoint);
  }

  public Map<Player, String> getResults() {
    return Collections.unmodifiableMap(results);
  }
}
