package ladder.view.output;

import java.util.stream.IntStream;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Point;

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
  }

  private static void printRow(Ladder ladder, int rowNumber) {
    ladder.getPointsOfRow(rowNumber).stream()
        .map(OutputLaddersView::ladder)
        .forEach(System.out::print);
    System.out.println();
  }

  private static String ladder(Point point) {
    if(point.getDirection().current()) {
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
