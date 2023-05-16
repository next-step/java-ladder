package ladder.domain.ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import ladder.domain.participant.Participant;
import ladder.domain.prize.Prize;

public class MatchResults {

  private final Map<Participant, Prize> results = new LinkedHashMap<>();



  public void addMatchResult(Participant participant, Prize prize) {
    results.put(participant, prize);
  }


  public Map<Participant, Prize> getAllResults() {
    return results;
  }

  public Prize getResult(Participant participant) {
    return results.get(participant);
  }
}
