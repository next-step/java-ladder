package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
  private final Map<Player, String> gameResult;

  public GameResult(Map<Player, String> resultByPlayer) {
    this.gameResult = new LinkedHashMap<>(resultByPlayer);
  }

  public String getResult(Player player) {
    if (!gameResult.containsKey(player)) {
      throw new IllegalArgumentException("존재하지 않는 참여자입니다.");
    }
    return gameResult.get(player);
  }

  public Map<Player, String> getAllResults() {
    return new LinkedHashMap<>(gameResult);
  }
}
