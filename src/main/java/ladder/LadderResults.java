package ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class LadderResults {

  private static final Prize DEFAULT_PRIZE = new Prize("꽝");

  private final Map<Name, Prize> results;

  LadderResults(Map<Name, Prize> results) {
    this.results = results;
  }

  public void put(Name player, Prize prize) {
    results.put(player, prize);
  }

  public Prize prizeOf(Name player) {
    return results.get(player);
  }

  public Set<Entry<Name, Prize>> allPlayersAndResults() {
    return results.entrySet();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LadderResults that = (LadderResults) o;
    return Objects.equals(results, that.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results);
  }

  public static LadderResults init(Players players) {
    Map<Name, Prize> map = new HashMap<>();
    for (Name player : players.playerNames()) {
      map.put(player, DEFAULT_PRIZE);
    }
    return new LadderResults(map);
  }
}
