package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.*;
import static ladder.domain.Players.JOIN;
import static ladder.domain.Players.SEPARATOR;

public class LadderResults {

  private List<LadderResult> ladderResults;

  private LadderResults(List<LadderResult> ladderResults) {
    this.ladderResults = Collections.unmodifiableList(ladderResults);
  }

  public static LadderResults of(String result, int size) {
    if (result.isEmpty()) {
      throw new IllegalArgumentException("입력이 없습니다.");
    }

    String[] strings = split(result, size);

    return Arrays.stream(strings)
        .map(String::trim)
        .map(LadderResult::of)
        .collect(collectingAndThen(toList(), LadderResults::new));
  }

  public LadderResult resultValue(int index) {
    return ladderResults.get(index);
  }

  private static String[] split(String result, int size) {
    String[] strings = result.split(SEPARATOR);
    if (strings.length != size) {
      throw new IllegalArgumentException("플레이어수와 결과 값은 같아야 합니다.");
    }

    return strings;
  }

  @Override
  public String toString() {
    return ladderResults.stream()
        .map(LadderResult::toString)
        .collect(joining(JOIN));
  }
}
