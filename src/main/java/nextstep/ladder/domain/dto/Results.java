package nextstep.ladder.domain.dto;

import java.util.List;

public class Results {
  private final List<String> results;

  public Results(List<String> results) {
    this.results = results;
  }

  public Results(String[] results) {
    this(List.of(results));
  }

  public String getResult(int index) {
    return results.get(index);
  }
}
