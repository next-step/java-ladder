package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class EndPoints {

  private static final String VALIDATE_MESSAGE = "실행 결과의 수는 플레이어의 수(%d)와 같아야 합니다.";

  private final List<String> endPoints;

  private EndPoints(List<String> values) {
    this.endPoints = values;
  }

  public static EndPoints of(List<String> values, int playerSize) {
    validateSize(values, playerSize);
    return new EndPoints(values);
  }

  private static void validateSize(List<String> values, int playerSize) {
    if (values.size() != playerSize) {
      throw new IllegalArgumentException(String.format(VALIDATE_MESSAGE, playerSize));
    }
  }

  public List<String> getResults() {
    return Collections.unmodifiableList(endPoints);
  }

  public String valueByIndex(int column) {
    return endPoints.get(column);
  }
}
