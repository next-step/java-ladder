package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {

  private List<LadderResult> ladderResults;

  public LadderResults(List<String> executionResult) {
    ladderResults = executionResult.stream()
        .map(LadderResult::new)
        .collect(Collectors.toList());
  }

  public void printAll() {
    ladderResults.forEach(LadderResult::print);
    System.out.println();
  }

  LadderResult resultAt(int index) {
    return ladderResults.get(index);
  }

}
