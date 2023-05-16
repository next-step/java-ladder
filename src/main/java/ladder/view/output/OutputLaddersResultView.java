package ladder.view.output;

import ladder.domain.prize.Prizes;

public class OutputLaddersResultView {


  public static void printPrizes(Prizes prizes) {
    prizes.getPrizes().forEach(prize -> System.out.printf("%-6s", prize.getPrize()));
    System.out.println();
    System.out.println();
  }

}
