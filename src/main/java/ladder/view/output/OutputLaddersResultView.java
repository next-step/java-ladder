package ladder.view.output;

import ladder.domain.LaddersResult;

public class OutputLaddersResultView {


  public static void printLaddersResult(LaddersResult laddersResult) {
    laddersResult.results().forEach(result -> System.out.printf("%-6s", result));
  }

}
