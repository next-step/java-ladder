package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;

public class ResultView {

  public static final String BLANK = "     ";
  public static final String HORIZONTAL_LINE = "-----";
  public static final String VERTICAL_LINE = "|";
  public static final StringBuilder sb = new StringBuilder();

  public static void print(Players players, Lines lines, Results results) {
    print(players);
    print(lines);
    print(results);
    System.out.println(sb);
  }

  public static void print(Result result) {
    System.out.println(result);
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
    sb.append(BLANK);
    line.positions().forEach(ResultView::printPosition);
    sb.append("\n");
  }

  private static void printPosition(Position position) {
    if (position.current()) {
      sb.append(VERTICAL_LINE + HORIZONTAL_LINE);
      return;
    }
    sb.append(VERTICAL_LINE + BLANK);
  }

  private static void print(Results results) {
    sb.append(BLANK + results + "\n");
  }
}
