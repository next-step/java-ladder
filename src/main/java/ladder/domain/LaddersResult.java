package ladder.domain;

import java.util.List;

public class LaddersResult {

  private final List<String> results;

  public LaddersResult(List<String> results) {
    this.results = results;
  }

  public List<String> results() {
    return results;
  }

}
