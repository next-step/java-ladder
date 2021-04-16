package nextstep.laddergame.ui;

import java.util.List;
import java.util.stream.Collectors;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Line;
import nextstep.laddergame.domain.Member;

public class OutputView {

  private static final String TRUE_LINE = "|-----";
  private static final String FALSE_LINE = "|     ";
  private static final String END_LINE = "|\n";
  private static final String BLANK = "   ";

  public void printNames(Ladder ladder) {
    String names = ladder
        .members()
        .names()
        .stream()
        .map(Member::name)
        .collect(Collectors.joining("\t"));

    System.out.println(names);
  }

  public void printLadderLine(Ladder ladder) {
    ladder.lines()
        .entireLine()
        .stream()
        .map(Line::points)
        .forEach(OutputView::printLine);
  }

  public static void printLine(List<Boolean> line) {
    StringBuilder sb = new StringBuilder();
    sb.append(BLANK);
    line.forEach(point -> sb.append(hasPoint(point)));
    sb.append(END_LINE);
    System.out.print(sb.toString());
  }

  public static String hasPoint(boolean point) {
    if(point) {
      return TRUE_LINE;
    }
    return FALSE_LINE;
  }

  public void printLadder(Ladder ladder) {
    printNames(ladder);
    printLadderLine(ladder);
  }
}
