package ladder.view.output;

import java.util.stream.IntStream;
import ladder.domain.Ladders;

public class OutputLaddersView {
  private static final String LADDER = "|-----";
  private static final String NOT_LADDER = "|     ";
  private static final String START_EMPTY_SPACE = "     ";
  private static final String LAST = "|";

  public static void printLadderOfRow(Ladders ladders) {
    IntStream.range(0, height(ladders)).forEach(rowNumber -> {
      printLaddersOfRow(ladders, rowNumber);
    });
  }

  private static int height(Ladders ladders) {
    return ladders.height();
  }

  private static void printLaddersOfRow(Ladders ladders, int rowNumber) {
    printStartEmptySpaceOfRow();
    printLadderOfRow(ladders, rowNumber);
    printLastLineOfRow();
  }

  private static void printLadderOfRow(Ladders ladders, int rowNumber) {
    ladders.getRow(rowNumber).stream()
        .map(OutputLaddersView::ladder)
        .forEach(System.out::print);
  }

  private static String ladder(Boolean connection) {
    if(connection) {
      return LADDER;
    }
    return NOT_LADDER;
  }

  private static void printLastLineOfRow() {
    System.out.println(LAST);
  }

  private static void printStartEmptySpaceOfRow() {
    System.out.print(START_EMPTY_SPACE);
  }

}
