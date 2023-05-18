package ladder.domain.ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import ladder.domain.participant.Name;
import ladder.domain.prize.Prize;

public class MatchResults {

  private final Map<Name, Prize> results = new LinkedHashMap<>();

  public void addMatchResult(Name participant, Prize prize) {
    results.put(participant, prize);
  }

  public Map<Name, Prize> getAllResults() {
    return results;
  }

  public Prize getResult(Name participant) {
    return results.get(participant);
  }
}
