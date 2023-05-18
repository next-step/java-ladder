package nextstep.laddergame.ui;

import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Member;
import nextstep.laddergame.domain.Members;
import nextstep.laddergame.domain.Point;
import nextstep.laddergame.domain.Row;

public class OutputView {

  private OutputView() {
  }

  public static void printResult(Members members, Ladder ladder) {
    printMembers(members);
    printLadder(ladder);
  }

  private static void printLadder(Ladder ladder) {
    for (Row row : ladder.getRows()) {
      for (Point point : row.getPoints()) {
        if (point.checkLeftWay()) {
          System.out.print("-".repeat(5));
        } else {
          System.out.print(" ".repeat(5));
        }
        System.out.print("|");
      }
      System.out.println();
    }
  }

  private static void printMembers(Members members) {
    System.out.println("실행결과");
    for (Member member : members.getMembers()) {
      String name = member.getName();
      String blank = " ".repeat(6 - name.length());
      System.out.print(blank + name);
    }
    System.out.println();
  }

}
