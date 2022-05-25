package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;

public class ResultView {

  public static final String BLANK = "     ";
  public static final String HORIZONTAL_LINE = "-----";
  public static final String VERTICAL_LINE = "|";

  public static void print(Players players) {
    System.out.println(BLANK + players);
  }
  public static void print(Ladder ladder) {
    printLines(ladder.lines());
  }

  private static void printLines(List<Line> lines) {
    lines.forEach(ResultView::printLine);
  }

  private static void printLine(Line line) {
    System.out.print(BLANK + VERTICAL_LINE);
    line.points().forEach(ResultView::printPoint);
    System.out.println();
  }

  private static void printPoint(Boolean point) {
    if (Boolean.TRUE.equals(point)) {
      System.out.print(HORIZONTAL_LINE + VERTICAL_LINE);
      return;
    }
    System.out.print(BLANK + VERTICAL_LINE);
  }

}
