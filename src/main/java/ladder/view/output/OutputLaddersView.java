package ladder.view.output;

import java.util.stream.IntStream;
import ladder.domain.ladder.Ladder;

public class OutputLaddersView {
  private static final String LADDER = "|-----";
  private static final String NOT_LADDER = "|     ";
  private static final String START_EMPTY_SPACE = "     ";
  private static final String LAST = "|";

  public static void printLadder(Ladder ladder) {
    IntStream.range(0, height(ladder)).forEach(rowNumber -> {
      printRowOfLadder(ladder, rowNumber);
    });
  }

  private static int height(Ladder ladder) {
    return ladder.height();
  }

  private static void printRowOfLadder(Ladder ladder, int rowNumber) {
    printStartEmptySpaceOfRow();
    printRow(ladder, rowNumber);
    printLastLineOfRow();
  }

  private static void printRow(Ladder ladder, int rowNumber) {
    ladder.getRow(rowNumber).stream()
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
