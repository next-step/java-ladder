package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Results {

  public static final String DELIMITER = ",";
  public static final String JOINING_DELIMITER = " ";
  private final List<Result> results;

  public Results(List<Result> results) {
    this.results = results;
  }

  public static List<Result> create(String playerNames) {
    validateEmpty(playerNames);
    return results(playerNames);
  }

  public int count() {
    return results.size();
  }

  private static void validateEmpty(String resultNames) {
    if (resultNames == null || resultNames.isBlank()) {
      throw new IllegalArgumentException("실행결과는 필수입니다.");
    }
  }

  private static List<Result> results(String resultNames) {
    return Arrays.stream(resultNames.split(DELIMITER))
        .map(Result::new)
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Results results1 = (Results) o;
    return Objects.equals(results, results1.results);
  }

  @Override
  public int hashCode() {
    return Objects.hash(results);
  }

  @Override
  public String toString() {
    return results.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(JOINING_DELIMITER));
  }
}
