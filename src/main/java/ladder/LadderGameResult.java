package ladder;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

  private Map<Player, String> gameResult = new HashMap<>();

  public void add(Player player, String result) {
    gameResult.put(player, result);
  }

  public Map<Player, String> getGameResult() {
    return Collections.unmodifiableMap(gameResult);
  }

}
