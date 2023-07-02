package nextstep.ladder.domain.dto;

import java.util.List;

public class GameResults {
  private final List<String> results;

  public GameResults(List<String> results) {
    this.results = results;
  }

  public GameResults(String[] results) {
    this(List.of(results));
  }

  public String getResult(int index) {
    return results.get(index);
  }

  public List<String> getResults() {
    return this.results;
  }
}
