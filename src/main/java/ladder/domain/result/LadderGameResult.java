package ladder.domain.result;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderGameResult {
  private final Map<String, LadderGamePlayerResult> playerResultMap;

  public LadderGameResult(List<LadderGamePlayerResult> playerResults) {
    this.playerResultMap = playerResults.stream()
        .collect(Collectors.toMap(LadderGamePlayerResult::getPlayerName, Function.identity()));
  }

  public LadderGamePlayerResult resultOfPlayer(String playerName) {
    return playerResultMap.get(playerName);
  }

  public Map<String, LadderGamePlayerResult> getPlayerResultMap() {
    return playerResultMap;
  }
}
