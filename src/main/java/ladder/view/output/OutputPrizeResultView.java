package ladder.view.output;

import java.util.Map;
import ladder.domain.participant.Participant;
import ladder.domain.prize.Prize;

public class OutputPrizeResultView {


  public static void printAllResults(Map<Participant, Prize> allResults) {
    System.out.println();
    System.out.println("실행 결과");
    allResults.forEach((participant, prize) -> System.out.printf("%s : %s%n", participant.getName().name(), prize.getPrize()));
    System.out.println();
  }

  public static void printResult(Prize prize) {
    System.out.println();
    System.out.println("실행 결과");
    System.out.println(prize.getPrize());
    System.out.println();
  }
}
