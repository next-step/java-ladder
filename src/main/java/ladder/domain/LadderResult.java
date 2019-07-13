package ladder.domain;

import java.util.Objects;

import static ladder.domain.Player.NAME_PRINT_FORMAT;

public class LadderResult {

  private final String result;

  private LadderResult(String result) {
    this.result = result;
  }

  public static LadderResult of(String result) {
    return new LadderResult(result);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LadderResult that = (LadderResult) o;
    return Objects.equals(result, that.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(result);
  }

  @Override
  public String toString() {
    return String.format(NAME_PRINT_FORMAT, result);
  }
}
