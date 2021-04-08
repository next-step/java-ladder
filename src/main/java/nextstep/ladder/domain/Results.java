package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

  private List<Result> results;

  private Results(List<Result> results) {
    this.results = results;
  }

  public static Results from(String[] results) {
    return new Results(Arrays.stream(results)
        .map(Result::generate)
        .collect(Collectors.toList()));
  }

  public int size() {
    return results.size();
  }

  public Result getResult(int index) {
    return results.get(index);
  }

}
