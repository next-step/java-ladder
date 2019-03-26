package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

  private List<Result> results;

  public Results(List<Result> results) {
    this.results = results;
  }

  @Override
  public String toString() {
    return results.stream()
        .map(result -> String.format("%5s", result))
        .collect(Collectors.joining(" "));
  }

  public Result position(int resultPosition) {
    return results.get(resultPosition);
  }
}
