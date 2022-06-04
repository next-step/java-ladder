package nextstep.ladder.domain;

import java.util.Objects;

public class Result {

  private final String result;

  public Result(String result) {
    validateEmpty(result);
    this.result = result.trim();
  }

  private void validateEmpty(String result) {
    if (isBlank(result)) {
      throw new IllegalArgumentException("결과는 비어 있을 수 없습니다.");
    }
  }

  private static boolean isBlank(String result) {
    return result == null || result.isBlank();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Result result1 = (Result) o;
    return Objects.equals(result, result1.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    return result;
  }

}
