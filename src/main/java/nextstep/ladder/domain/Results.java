package nextstep.ladder.domain;

import java.util.List;

public class Results {

  private static final String VALIDATE_MESSAGE = "실행 결과의 수는 플레이어의 수(%d)와 같아야 합니다.";

  private final List<String> results;

  private Results(List<String> values) {
    this.results = values;
  }

  public static Results of(List<String> values, int playerSize) {
    validateSize(values, playerSize);
    return new Results(values);
  }

  private static void validateSize(List<String> values, int playerSize) {
    if (values.size() != playerSize) {
      throw new IllegalArgumentException(String.format(VALIDATE_MESSAGE, playerSize));
    }
  }

  public List<String> getResults() {
    return results;
  }
}
