package nextstep.laddergame.ui;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import nextstep.laddergame.domain.Award;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.LadderBoard;
import nextstep.laddergame.domain.Line;
import nextstep.laddergame.domain.Name;
import nextstep.laddergame.domain.Point;

public class OutputView {

  private static final String TRUE_LINE = "|-----";
  private static final String FALSE_LINE = "|     ";
  private static final String END_LINE = "|\n";
  private static final String BLANK = "   ";
  private static final String SEPARATOR = " : ";

  private void printNames(Ladder ladder) {
    String names = ladder
        .members()
        .names()
        .stream()
        .map(Name::name)
        .collect(Collectors.joining("\t"));

    System.out.println(names);
  }

  private void printLadderLine(Ladder ladder) {
    ladder.lines()
        .entireLine()
        .stream()
        .map(Line::points)
        .forEach(OutputView::printLine);
  }

  private static void printLine(List<Point> line) {
    StringBuilder sb = new StringBuilder();
    sb.append(BLANK);
    line.forEach(point -> sb.append(hasPoint(point)));
    sb.append(END_LINE);
    System.out.print(sb.toString());
  }

  private void printAward(Award award) {
    System.out.println(award.prizes()
        .collect(Collectors.joining("\t")));
  }

  private static String hasPoint(Point point) {
    if(point.hasRight())
      return TRUE_LINE;
    return FALSE_LINE;
  }

  public void printLadder(Ladder ladder, Award award) {
    printNames(ladder);
    printLadderLine(ladder);
    printAward(award);
  }

  public void printLadderResult(Name member, LadderBoard ladderBoard) {
    System.out.println(ladderBoard.findOne(member));
  }

  public void printAllLadderResult(LadderBoard ladderBoard) {
    printMemberAndPrize(ladderBoard.findAll());
  }

  private void printMemberAndPrize(Map<Name, Name> resultAll) {
    resultAll.keySet()
        .stream()
        .map(key -> key.name() + SEPARATOR + resultAll.get(key).name())
        .forEach(System.out::println);
  }
}
