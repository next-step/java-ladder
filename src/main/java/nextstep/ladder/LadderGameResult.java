package nextstep.ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGameResult {
  private final Map<String, String> results;

  public LadderGameResult(Map<String, String> results){
    this.results = results;
  }

  public LadderGameResult(List<String> participants, List<String> ladderResults) {
    this(create(participants, ladderResults));
  }

  private static Map<String, String> create(List<String> participants, List<String> ladderResults){
    Map<String, String> results =  new HashMap<>();
    for (int i = 0; i < participants.size(); i++) {
      results.put(participants.get(i), ladderResults.get(i));
    }
    return results;
  }

  public String getResult(String name) {
    return results.get(name);
  }

  public Map<String, String> getAllResults() {
    return new HashMap<>(results);
  }
}
