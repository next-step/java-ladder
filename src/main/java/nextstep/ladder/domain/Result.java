package nextstep.ladder.domain;

import java.util.Objects;

public final class Result {

  private final String result;

  public Result(String result) {
    this.result = result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Result)) {
      return false;
    }
    Result result1 = (Result) o;
    return Objects.equals(result, result1.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }
}
