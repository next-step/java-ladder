package nextstep.laddergame.ui;

import java.util.List;
import java.util.Map;
import nextstep.laddergame.domain.GameResult;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Member;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.domain.Point;
import nextstep.laddergame.domain.Prize;
import nextstep.laddergame.domain.Prizes;
import nextstep.laddergame.domain.Row;

public class OutputView {

  private static final int LINE_WIDTH = 5;

  private OutputView() {
  }

  public static void printLadder(Members members, Ladder ladder, Prizes prizes) {
    printMembers(members.getMembers());
    printLadder(ladder);
    printPrizes(prizes.getPrizes());
  }

  private static void printMembers(List<Member> members) {
    System.out.println("실행결과");
    members.forEach(OutputView::printMember);
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

  private static void printPrizes(List<Prize> results) {
    results.forEach(OutputView::printLadder);
    System.out.println();
  }

  private static void printLadder(Prize result) {
    String resultStr = result.getPrize();
    String blank = " ".repeat(LINE_WIDTH + 1 - resultStr.length());
    System.out.print(blank + resultStr);
  }

  public static void printGameResult(GameResult gameResult) {
    Map<Member, Prize> resultMap = gameResult.getResultMap();
    resultMap.forEach((member, prize) -> {
      System.out.println(member.getName() + " : " + prize.getPrize());
    });
  }

  public static void printGameResultOfMember(Member member, GameResult gameResult) {
    Prize prize = gameResult.getResultOfMember(member);
    System.out.println(member.getName() + " : " + prize.getPrize());
  }
}
