package ladder.domain;

import ladder.util.StringUtil;

import java.util.List;
import java.util.Objects;

public class Result {
  private final List<String> values;

  private Result(List<String> values) {
    this.values = values;
  }

  public static Result generate(String inputString) {
    return new Result(StringUtil.toList(inputString));
  }

  public String get(Record record, Player player) {
    return values.get(record.get(player));
  }

  public List<String> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Result result = (Result) o;
    return Objects.equals(values, result.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Result{" +
            "values=" + values +
            '}';
  }
}
