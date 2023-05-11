package ladder.view.output;

import java.util.stream.IntStream;
import ladder.domain.Ladders;

public class OutputLaddersView {
  private static final String LADDER = "|-----";
  private static final String NOT_LADDER = "|     ";
  private static final String START_EMPTY_SPACE = "     ";
  private static final String LAST = "|";

  public static void printLadder(Ladders ladders) {
    IntStream.range(0, ladders.height()).forEach(rowNumber -> {
      printStartEmptySpace();
      ladders.getRow(rowNumber).stream()
          .map(OutputLaddersView::ladder)
          .forEach(System.out::print);
      printLastLine();
    });
  }

  private static String ladder(Boolean connection) {
    if(connection) {
      return LADDER;
    }
    return NOT_LADDER;
  }

  private static void printLastLine() {
    System.out.println(LAST);
  }

  private static void printStartEmptySpace() {
    System.out.print(START_EMPTY_SPACE);
  }

}
