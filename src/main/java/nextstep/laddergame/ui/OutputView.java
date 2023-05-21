package nextstep.laddergame.ui;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Member;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.domain.Point;
import nextstep.laddergame.domain.Row;

public class OutputView {

  private static final int LINE_WIDTH = 5;

  private OutputView() {
  }

  public static void printResult(Members members, Ladder ladder) {
    printMembers(members);
    printLadder(ladder);
  }

  private static void printMembers(Members members) {
    System.out.println("실행결과");
    members.getMembers().forEach(OutputView::printMember);
    System.out.println();
  }

  private static void printMember(Member member) {
    String name = member.getName();
    String blank = " ".repeat(LINE_WIDTH + 1 - name.length());
    System.out.print(blank + name);
  }

  private static void printLadder(Ladder ladder) {
    ladder.getRows().forEach(OutputView::printRow);
  }

  private static void printRow(Row row) {
    row.getPoints().forEach(OutputView::printLine);
    System.out.println();
  }

  private static void printLine(Point point) {
    String line = point.checkLeftWay() ? "-" : " ";
    System.out.print(line.repeat(LINE_WIDTH) + "|");
  }
}
