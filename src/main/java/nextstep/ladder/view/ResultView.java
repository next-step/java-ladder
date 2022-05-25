package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Players;

public class ResultView {

  public static final String BLANK = "     ";
  public static final String HORIZONTAL_LINE = "-----";
  public static final String VERTICAL_LINE = "|";
  public static final StringBuilder sb = new StringBuilder();

  public static void print(Players players, Lines lines) {
    print(players);
    print(lines);
    System.out.println(sb);
  }

  private static void print(Players players) {
    sb.append(BLANK + players + "\n");
  }
  private static void print(Lines lines) {
    printLines(lines.lines());
  }

  private static void printLines(List<Line> lines) {
    lines.forEach(ResultView::printLine);
  }

  private static void printLine(Line line) {
    sb.append(BLANK + VERTICAL_LINE);
    line.points().forEach(ResultView::printPoint);
    sb.append("\n");
  }

  private static void printPoint(Boolean point) {
    if (Boolean.TRUE.equals(point)) {
      sb.append(HORIZONTAL_LINE + VERTICAL_LINE);
      return;
    }
    sb.append(BLANK + VERTICAL_LINE);
  }

}
