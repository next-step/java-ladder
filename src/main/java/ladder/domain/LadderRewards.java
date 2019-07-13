package ladder.domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class LadderRewards {
  private final Map<Player, LadderResult> results;

  private LadderRewards(Map<Player, LadderResult> results) {
    this.results = results;
  }

  public static LadderRewards of(Map<Player, LadderResult> results) {
    return new LadderRewards(results);
  }

  public String searchPlayer(String resultName) {
    return results.keySet()
        .stream()
        .filter(player -> player.isPlayerName(resultName))
        .map(results::get)
        .map(LadderResult::toString)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("잘못된 이름입니다."));
  }

  public List<String> allPlayer() {
    return results.entrySet()
        .stream()
        .map(playersResult())
        .collect(toList());
  }

  private Function<Map.Entry<Player, LadderResult>, String> playersResult() {
    return set -> set.getKey().toString() + ":" + set.getValue().toString();
  }
}
