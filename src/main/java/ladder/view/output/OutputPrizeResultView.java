package ladder.view.output;

import java.util.List;
import ladder.domain.ladder.MatchResult;
import ladder.domain.prize.Prize;

public class OutputPrizeResultView {


  public static void printAllResults(List<MatchResult> allResults) {
    System.out.println();
    System.out.println("실행 결과");
    for (MatchResult matchResult : allResults) {
      System.out.printf("%s : %s%n", matchResult.getParticipantName(), matchResult.getPrize());
    }
  }

  public static void printResult(Prize prize) {
    System.out.println();
    System.out.println("실행 결과");
    System.out.println(prize.getPrize());
    System.out.println();
  }
}
