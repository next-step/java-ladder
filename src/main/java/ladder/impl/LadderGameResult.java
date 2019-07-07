package ladder.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

  private Map<String, String> gameResult = new HashMap<>();

  public void add(String playerName, String target) {
    gameResult.put(playerName, target);
  }

  public Map<String, String> getGameResult() {
    return Collections.unmodifiableMap(gameResult);
  }

  public String getGameResult(String playerName) {
    return gameResult.get(playerName);
  }
}
