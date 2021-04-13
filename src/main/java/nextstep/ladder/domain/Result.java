package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.EmptyStringNotAllowedException;
import nextstep.ladder.exception.OverResultLengthLimitException;

public final class Result {

  public static final int MAX_LENGTH = 5;

  private final String result;

  public Result(String result) {
    validateEmptyString(result);
    validateLength(result);

    this.result = result;
  }

  private void validateEmptyString(String result) {
    if (result.isEmpty()) {
      throw new EmptyStringNotAllowedException();
    }
  }

  private void validateLength(String result) {
    if (result.length() > MAX_LENGTH) {
      throw new OverResultLengthLimitException();
    }
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
